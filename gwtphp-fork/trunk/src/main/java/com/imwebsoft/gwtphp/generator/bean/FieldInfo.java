package com.imwebsoft.gwtphp.generator.bean;

/**
 * @author Mile
 * 
 */
public class FieldInfo {

	private String name;
	private String nameUpper;
	private TypeInfo typeInfo;

	/**
	 * 
	 */
	public FieldInfo() {
		super();
	}

	/**
	 * @param name
	 * @param nameUpper
	 * @param typeInfo
	 */
	public FieldInfo(String name, String nameUpper, TypeInfo typeInfo) {
		super();
		this.name = name;
		this.nameUpper = nameUpper;
		this.typeInfo = typeInfo;
	}

	/**
	 * @return the typeInfo
	 */
	public TypeInfo getTypeInfo() {
		return this.typeInfo;
	}

	/**
	 * @param typeInfo
	 *            the typeInfo to set
	 */
	public void setTypeInfo(TypeInfo typeInfo) {
		this.typeInfo = typeInfo;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nameUpper
	 */
	public String getNameUpper() {
		return this.nameUpper;
	}

	/**
	 * @param nameUpper
	 *            the nameUpper to set
	 */
	public void setNameUpper(String nameUpper) {
		this.nameUpper = nameUpper;
	}

}
