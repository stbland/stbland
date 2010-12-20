package com.imwebsoft.gwtphp.generator;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.imwebsoft.gwtphp.generator.bean.FileInfo;
import com.imwebsoft.gwtphp.generator.util.FileParser;

/**
 * Generates back-end code for GWT-PHP framework
 * 
 * @author Milan Dinic
 * @version 1.0
 * @email milandinic83@gmail.com
 */
public class Generator {

	private String service = "service";
	private String outPath;
	private FileParser fileParser = new FileParser();
	private List<FileInfo> fileInfos;

	/**
	 * Simple rules:<br>
	 * Bean: <br>
	 * -field must have public, private or protected <br>
	 * -must have default constructor <br>
	 * -fields must be located above default constructor <br>
	 * -methods must be located after default constructor <br>
	 * -package name must contain bean or beans string (does not have to be last package with this name) <br>
	 * 
	 * Service: <br>
	 * -use service interface for data grabbing <br>
	 * -file name must contain Service string <br>
	 * -methods must begin with public <br>
	 * 
	 * Service implementation in PHP: <br>
	 * -must be in same folder as service interface <br>
	 * -methods must have same name to cooresponding methods in service interface <br>, parameters will be ignored<br>
	 * 
	 * Array right way : String[] strings; <br>
	 * Array wrong way : String strings[]; <br>
	 * 
	 * @param srcDir
	 *            root path to client folder of GWT project, will process all sub folders
	 * 
	 * @param outPath
	 *            path where files will be created, will overwrite existing files
	 * @throws Exception
	 * 
	 */
	public Generator(File srcDir, String outPath) throws Exception {
		this.outPath = outPath;
		fileParser.processDirectory(srcDir);
		fileInfos = fileParser.getFileInfos();
		for (int i = 0; i < fileInfos.size(); i++) {
			generate(fileInfos.get(i));
		}
	}

	/**
	 * 
	 * @param fileInfo
	 */
	public void generate(FileInfo fileInfo) {
		FileWriter fileWriterBean;
		FileWriter fileWriterBeanMapping;
		FileWriter fileWriterService;
		FileWriter fileWriterServiceMapping;
		Template templateBean = null;
		Template templateBeanMapping = null;
		Template templateService = null;
		Template templateServiceMapping = null;

		Properties props = new Properties();
		props.setProperty("resource.loader", "class");
		props.put("resource.loader", "class");
		props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		props.put("class.resource.loader.path", fileInfo.getPath());
		props.put("directive.foreach.counter.initial.value", "0");
		VelocityContext context = new VelocityContext();
		context.put("fileInfo", fileInfo);
		updatePathForImport(fileInfo);
		context.put("fileInfos", fileInfos);
		try {
			Velocity.init(props);
			String filePath = outPath + "/" + fileInfo.getPackageName().replace('.', '/') + "/";
			new File(filePath).mkdirs();
			if (fileInfo.getFileType().equals(service)) {
				fileWriterService = new FileWriter(new File(filePath + fileInfo.getClassName() + ".class.php"));
				fileWriterServiceMapping = new FileWriter(new File(filePath + fileInfo.getClassName() + ".gwtphpmap.inc.php"));

				templateService = Velocity.getTemplate("template/gwtphp/Service.vm");
				templateServiceMapping = Velocity.getTemplate("template/gwtphp/Service.gwtphpmap.inc.vm");
				context.put("gwtphpmap", "$gwtphpmap");

				templateService.merge(context, fileWriterService);
				templateServiceMapping.merge(context, fileWriterServiceMapping);

				fileWriterService.flush();
				fileWriterService.close();
				fileWriterServiceMapping.flush();
				fileWriterServiceMapping.close();
			} else if (fileInfo.getFileType().equals("bean")) {// if (fileInfo.getPackageName().contains(beanString) ||
				// bean
				fileWriterBean = new FileWriter(new File(filePath + fileInfo.getClassName() + ".class.php"));
				fileWriterBeanMapping = new FileWriter(new File(filePath + fileInfo.getClassName() + ".gwtphpmap.inc.php"));
				templateBean = Velocity.getTemplate("template/gwtphp/Bean.vm");
				templateBeanMapping = Velocity.getTemplate("template/gwtphp/Bean.gwtphpmap.inc.vm");

				context.put("this-", "$this-");
				context.put("gwtphpmap", "$gwtphpmap");

				templateBean.merge(context, fileWriterBean);
				templateBeanMapping.merge(context, fileWriterBeanMapping);

				fileWriterBean.flush();
				fileWriterBean.close();
				fileWriterBeanMapping.flush();
				fileWriterBeanMapping.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param fileInfo
	 */
	private void updatePathForImport(FileInfo fileInfo) {
		if (!fileInfo.getFileType().equals("bean")) {
			for (int i = 0; i < fileInfos.size(); i++) {
				if (fileInfos.get(i).getFileType().equals("bean")) {
					fileInfos.get(i).setPathForImport(
							fileInfos.get(i).getPackageName().substring(fileInfo.getPackageName().length() + 1,
									fileInfos.get(i).getPackageName().length()));
				}
			}
		}
	}
}
