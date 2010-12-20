package com.imwebsoft.gwtphp.generator.bean;

import java.util.List;

/**
 * @author Mile
 * 
 */
public class FileInfo {

	private String parentClass;
	private String packageName;
	private String className;
	private String typeCRC;
	private String path;
	private List<FieldInfo> list;
	private List<MethodInfo> methods;
	private List<String> imports;
	private List<String> exceptions;
	private List<String> includes;
	private String fileType; // bean or service

	private String pathForImport;

	/**
	 * 
	 */
	public FileInfo() {
		super();
	}

	/**
	 * @param packageName
	 * @param className
	 * @param path
	 * @param list
	 */
	public FileInfo(String packageName, String className, String path,
			List<FieldInfo> list, String parentClass, List<String> imports,
			List<MethodInfo> methods, List<String> exceptions, String fileType) {
		super();
		this.packageName = packageName;
		this.className = className;
		this.path = path;
		this.list = list;
		this.parentClass = parentClass;
		this.imports = imports;
		this.methods = methods;
		this.fileType = fileType;
		this.exceptions = exceptions;
	}

	/**
	 * @return the pathForImport
	 */
	public String getPathForImport() {
		return this.pathForImport;
	}

	/**
	 * @param pathForImport
	 *            the pathForImport to set
	 */
	public void setPathForImport(String pathForImport) {
		this.pathForImport = pathForImport;
	}

	/**
	 * @return the fileType
	 */
	public String getFileType() {
		return this.fileType;
	}

	/**
	 * @param fileType
	 *            the fileType to set
	 */
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	/**
	 * @return the imports
	 */
	public List<String> getImports() {
		return this.imports;
	}

	/**
	 * @param imports
	 *            the imports to set
	 */
	public void setImports(List<String> imports) {
		this.imports = imports;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return this.className;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return this.path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the list
	 */
	public List<FieldInfo> getList() {
		return this.list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<FieldInfo> list) {
		this.list = list;
	}

	/**
	 * @return the packageName
	 */
	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * @param packageName
	 *            the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * @return the typeCRC
	 */
	public String getTypeCRC() {
		return this.typeCRC;
	}

	/**
	 * @param typeCRC
	 *            the typeCRC to set
	 */
	public void setTypeCRC(String typeCRC) {
		this.typeCRC = typeCRC;
	}

	/**
	 * @return the parentClass
	 */
	public String getParentClass() {
		return this.parentClass;
	}

	/**
	 * @param parentClass
	 *            the parentClass to set
	 */
	public void setParentClass(String parentClass) {
		this.parentClass = parentClass;
	}

	/**
	 * @return the methods
	 */
	public List<MethodInfo> getMethods() {
		return this.methods;
	}

	/**
	 * @param methods
	 *            the methods to set
	 */
	public void setMethods(List<MethodInfo> methods) {
		this.methods = methods;
	}

	public List<String> getExceptions() {
		return this.exceptions;
	}

	public void setExceptions(List<String> exceptions) {
		this.exceptions = exceptions;
	}

	public List<String> getIncludes() {
		return includes;
	}

	public void setIncludes(List<String> includes) {
		this.includes = includes;
	}

}
