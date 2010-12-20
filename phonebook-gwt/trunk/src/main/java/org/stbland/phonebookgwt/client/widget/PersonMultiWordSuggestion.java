package org.stbland.phonebookgwt.client.widget;

import org.stbland.phonebookgwt.bean.PersonDto;

import com.google.gwt.user.client.ui.MultiWordSuggestOracle.MultiWordSuggestion;

public class PersonMultiWordSuggestion extends MultiWordSuggestion {

	private PersonDto person;

	public PersonMultiWordSuggestion(PersonDto person) {
		this.person = person;
	}

	@Override
	public String getDisplayString() {
		return person.getFullName();
	}

	@Override
	public String getReplacementString() {
		return super.getReplacementString();
	}

}
