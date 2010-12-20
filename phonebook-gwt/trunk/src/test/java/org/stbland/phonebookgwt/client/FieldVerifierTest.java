package org.stbland.phonebookgwt.client;

import org.stbland.phonebookgwt.shared.FieldVerifier;

public class FieldVerifierTest extends AbstractPhonebookTestcase {

	/**
	 * Tests the FieldVerifier.
	 */
	public void testFieldVerifier() {
		assertFalse(FieldVerifier.isValidName(null));
		assertFalse(FieldVerifier.isValidName(""));
		assertFalse(FieldVerifier.isValidName("a"));
		assertFalse(FieldVerifier.isValidName("ab"));
		assertFalse(FieldVerifier.isValidName("abc"));
		assertTrue(FieldVerifier.isValidName("abcd"));
	}
}
