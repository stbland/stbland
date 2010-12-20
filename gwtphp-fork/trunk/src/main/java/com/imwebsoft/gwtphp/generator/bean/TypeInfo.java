package com.imwebsoft.gwtphp.generator.bean;

import com.imwebsoft.gwtphp.generator.util.SignatureUtil;

/**
 * @author Mile
 * 
 */
/**
 * @author Mile
 * 
 */
public class TypeInfo {

	// private String shortType;
	private String type;
	private String crc;
	private boolean simple;

	/**
	 * 
	 */
	public TypeInfo() {
		super();
	}

	/**
	 * @param shortType
	 * @param type
	 * @param crc
	 * @param simple
	 */
	public TypeInfo(String shortType, String type) {
		super();
		if (!type.startsWith("TypeSignatures")) {

			String innerType;
			if (type.startsWith("[")) {
				innerType = SignatureUtil.getSignature(type.substring(2, type
						.length() - 1));
				this.crc = SignatureUtil.getSignature(type) + "[L" + innerType
						+ ";";
			} else {
				this.crc = SignatureUtil.getSignature(type);
			}
			this.simple = false;
			this.type = "'" + type + "'";
		} else {

			this.simple = true;
			this.type = type;
		}

	}

	public TypeInfo(String type) {
		super();

		if (type.equals("void")) {
			simple = true;
			this.type = type;
		} else if (!type.startsWith("TypeSignatures")) {

			String innerType;
			if (type.startsWith("[")) {
				innerType = SignatureUtil.getSignature(type.substring(2, type
						.length() - 1));
				this.crc = SignatureUtil.getSignature(type) + "[L" + innerType
						+ ";";
			} else {
				this.crc = SignatureUtil.getSignature(type);
			}
			this.simple = false;
			this.type = "'" + type + "'";
		} else {
			this.simple = true;
			this.type = type;
		}

	}

	/**
	 * @return the simple
	 */
	public boolean isSimple() {
		return this.simple;
	}

	/**
	 * @param simple
	 *            the simple to set
	 */
	public void setSimple(boolean simple) {
		this.simple = simple;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the crc
	 */
	public String getCrc() {
		return this.crc;
	}

	/**
	 * @param crc
	 *            the crc to set
	 */
	public void setCrc(String crc) {
		this.crc = crc;
	}

}
