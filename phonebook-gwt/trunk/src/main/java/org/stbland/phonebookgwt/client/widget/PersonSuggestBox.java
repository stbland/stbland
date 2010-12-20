package org.stbland.phonebookgwt.client.widget;

import com.google.gwt.user.client.ui.SuggestBox;

public class PersonSuggestBox extends SuggestBox {

	public PersonSuggestBox() {
		super(new PersonSuggestOracle());

	}
}