package org.stbland.phonebookgwt.server;

import org.stbland.phonebookgwt.bean.PhoneDto;
import org.stbland.phonebookgwt.client.service.PhoneService;
import org.stbland.phonebookgwt.shared.FieldVerifier;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class PhoneServiceImpl extends AbtractService implements PhoneService {

	public PhoneDto findPhone(String personName)
			throws IllegalArgumentException {

		if (!FieldVerifier.isValidName(personName)) {
			// If the input is not valid, throw an IllegalArgumentException back
			// to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}
		PhoneDto dto = new PhoneDto();
		dto.setPoste("5116");
		return dto;
	}

}
