package org.stbland.phonebookgwt.bean;

@SuppressWarnings("serial")
public class PersonDto extends AbstractDto {

	private String firstName;
	private String lastName;

	public PersonDto() {
		super();
	}

	public PersonDto(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
}
