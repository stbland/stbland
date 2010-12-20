package com.imwebsoft.gwtphp.generator.bean;

import java.util.List;

/**
 * @author Mile
 * 
 */
public class MethodInfo {

	private String name;
	private TypeInfo returnType;
	private List<FieldInfo> params;
	private String body;

	/**
	 * 
	 */
	public MethodInfo() {
		super();
		this.body = " ";
	}

	/**
	 * @param name
	 * @param returnType
	 * @param params
	 * @param body
	 */
	public MethodInfo(String name, TypeInfo returnType, List<FieldInfo> params) {
		super();
		this.name = name;
		this.returnType = returnType;
		this.params = params;
		this.body = " ";
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return this.body;
	}

	/**
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body) {
		this.body = body;
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
	 * @return the params
	 */
	public List<FieldInfo> getParams() {
		return this.params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(List<FieldInfo> params) {
		this.params = params;
	}

	/**
	 * @return the returnType
	 */
	public TypeInfo getReturnType() {
		return this.returnType;
	}

	/**
	 * @param returnType
	 *            the returnType to set
	 */
	public void setReturnType(TypeInfo returnType) {
		this.returnType = returnType;
	}

}
