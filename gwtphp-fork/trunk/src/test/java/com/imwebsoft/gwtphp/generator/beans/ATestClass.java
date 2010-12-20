package com.imwebsoft.gwtphp.generator.beans;

/**
 * @author mdinic
 * 
 */
public class ATestClass extends Master {

	private long id;
	private String myName;
	private String[] myArray;
	private Boolean myBool;

	/**
	 * 
	 */
	public ATestClass() {
		super();
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMyName() {
		return this.myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	public String[] getMyArray() {
		return this.myArray;
	}

	public void setMyArray(String[] myArray) {
		this.myArray = myArray;
	}

	public Boolean getMyBool() {
		return this.myBool;
	}

	public void setMyBool(Boolean myBool) {
		this.myBool = myBool;
	}

}
