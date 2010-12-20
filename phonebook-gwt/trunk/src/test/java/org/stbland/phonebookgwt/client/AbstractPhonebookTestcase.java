package org.stbland.phonebookgwt.client;

import com.google.gwt.junit.client.GWTTestCase;

public abstract class AbstractPhonebookTestcase extends GWTTestCase {
	/**
	 * Must refer to a valid module that sources this class.
	 */
	public String getModuleName() {
		return "org.stbland.phonebookgwt.phonebook_test";
	}
}
