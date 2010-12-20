/**
 * 
 */
package com.imwebsoft.gwtphp.generator.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.imwebsoft.gwtphp.generator.bean.FileInfo;
import com.imwebsoft.gwtphp.generator.bean.MethodInfo;

/**
 * @author Mile
 * 
 */
public class FileParser {

	private List<FileInfo> fileInfos = new ArrayList<FileInfo>();
	// private CharSequence beanString = "bean";
	// private CharSequence beansString = "beans";
	private CharSequence classString = "class";
	private CharSequence interfaceString = "interface";
	private CharSequence packageString = "package ";
	private CharSequence extendsString = "extends";
	private CharSequence functionString = "function";
	private String service = "service";
	// private CharSequence brackets = "()";
	// private CharSequence staticString = "static";
	private CharSequence privateString = "private";
	private CharSequence publicString = "public";
	private final String require_once = "require_once";

	/**
	 * 
	 * @param srcDir
	 * @throws Exception
	 */
	public void processDirectory(File srcDir) throws Exception {

		if (srcDir.isDirectory()) {
			String[] children = srcDir.list();
			for (int i = 0; i < children.length; i++) {
				processDirectory(new File(srcDir, children[i]));
			}
		} else {
			if (srcDir.getAbsolutePath().endsWith(".java")) {
				// FileInfo fileInfo = processFile(srcDir);
				FileInfo fileInfo = processFileUsingRef(srcDir);
				if (fileInfo != null) {
					fileInfos.add(fileInfo);
				}
			}
		}
	}

	private FileInfo processFileUsingRef(File src) throws Exception {
		List<String> imports = new ArrayList<String>();
		FileReader fileReader = new FileReader(src);
		BufferedReader reader = new BufferedReader(fileReader);
		String packageName = null;
		String line = "";
		String publicContructor = "public "
				+ src.getName().replaceAll(".java", "()");

		String parentClass = "";
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			if (line.indexOf(publicContructor) != -1) {// exit this file
				break;
			} else if (line.contains(packageString)) {// get package
				packageName = line.replaceAll(";", "").replaceAll(
						packageString.toString(), "").trim();
			} else if (line.trim().startsWith("import")) {
				String[] strings = line.trim().replaceAll(";", "").split(" ");
				imports.add(strings[1]);
			} else if (line.contains(classString)
					|| line.contains(interfaceString)) {// class
				// or
				// interface
				// declaration
				parentClass = getParentClassname(line, imports, packageName);
			}
		}
		reader.close();
		fileReader.close();
		FileInfo fileInfo = FileTypeUtil.getFileInfo(parentClass, packageName
				+ "." + src.getName().replaceAll(".java", ""), src
				.getAbsolutePath());

		// FileInfo fileInfo = new FileInfo(packageName,
		// src.getName().replaceAll(".java", ""), src.getParentFile()
		// .getAbsolutePath(), fields, parentClass, imports, methods, fileType);
		if (fileInfo == null) {
			return null;
		}
		fileInfo.setTypeCRC(SignatureUtil.getSignature(fileInfo
				.getPackageName()
				+ "." + fileInfo.getClassName()));
		lookForMethodsBodys(fileInfo);
		lookForIncludes(fileInfo);
		return fileInfo;
	}

	/**
	 * 
	 * @param fileInfo
	 * @throws IOException
	 */
	private void lookForMethodsBodys(FileInfo fileInfo) throws IOException {
		if (fileInfo.getFileType().equals(service)) {
			String fileName = fileInfo.getPath().substring(0,
					fileInfo.getPath().length() - 5)
					+ ".php";
			MethodInfo infoWithBody;
			File methodFile = new File(fileName);
			String line = "";
			String body = "\n";
			String functionName = "";
			if (methodFile.exists()) {
				infoWithBody = new MethodInfo();
				FileReader fileReader = new FileReader(methodFile);
				BufferedReader reader = new BufferedReader(fileReader);
				while ((line = reader.readLine()) != null) {
					if (line.trim().contains(functionString)) {
						List<MethodInfo> methods = fileInfo.getMethods();
						for (Object element : methods) {
							MethodInfo methodInfo = (MethodInfo) element;
							if (methodInfo.getName().equalsIgnoreCase(
									functionName)) {
								methodInfo.setBody(body);
								break;
							}
						}

						body = line;
						line = line.trim().replaceAll(
								functionString.toString(), "").replaceAll(
								publicString.toString(), "").replaceAll(
								privateString.toString(), "").trim();

						functionName = line.substring(0, line.indexOf("("));
						infoWithBody.setName(line);
					} else {
						if (!line.trim().equals("?>")) {
							body = body + line + "\n";
						}
					}
				}

				List<MethodInfo> methods = fileInfo.getMethods();
				for (Object element : methods) {
					MethodInfo methodInfo = (MethodInfo) element;
					if (methodInfo.getName().equalsIgnoreCase(functionName)) {
						methodInfo.setBody(body);
						break;
					}
				}
			}
		}
	}

	private void lookForIncludes(FileInfo fileInfo) throws IOException {
		if (fileInfo.getFileType().equals(service)) {
			final List<String> includes = new ArrayList<String>();
			String fileName = fileInfo.getPath().substring(0,
					fileInfo.getPath().length() - 5)
					+ ".php";
			File serviceFile = new File(fileName);
			if (serviceFile.exists()) {
				FileReader fileReader = new FileReader(serviceFile);
				BufferedReader reader = new BufferedReader(fileReader);
				String line = "";
				while ((line = reader.readLine()) != null) {
					if (line.trim().startsWith(require_once)) {
						includes.add(line);
					}
				}
				fileInfo.setIncludes(includes);
			}
		}
	}

	/**
	 * 
	 * @param line
	 * @param imports
	 * @param packageName
	 * @return
	 */
	private String getParentClassname(String line, List<String> imports,
			String packageName) {
		String parentClass = "";
		if (line.contains(extendsString)) {
			String[] strings = line.split(" ");
			for (int i = 0; i < strings.length; i++) {
				if (strings[i].equals(extendsString.toString())) {
					parentClass = strings[i + 1];
					String parentClassOriginal = parentClass;

					// look for parent class in imports
					for (int j = 0; j < imports.size(); j++) {
						if (imports.get(j).endsWith(parentClass)) {
							parentClass = imports.get(j);
							break;
						}
					}
					// check was import for parent class found
					if (parentClass.equals(parentClassOriginal)) {
						// must be in same package
						parentClass = packageName + "." + parentClass;
					}
				}
			}
		}
		return parentClass;
	}

	/**
	 * @return the fileInfos
	 */
	public List<FileInfo> getFileInfos() {
		return this.fileInfos;
	}
}
