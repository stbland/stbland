package org.stbland.phonebookgwt.bean;

@SuppressWarnings("serial")
public class PhoneDto extends AbstractDto {

	public PhoneDto() {
		super();
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	private String poste;
}
