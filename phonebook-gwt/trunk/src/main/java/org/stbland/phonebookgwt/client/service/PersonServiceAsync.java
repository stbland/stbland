package org.stbland.phonebookgwt.client.service;

import java.util.AbstractList;

import org.stbland.phonebookgwt.bean.PersonDto;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The client side stub for the RPC service.
 * 
 * @see PersonService
 */
public interface PersonServiceAsync {

	void find(String firstName, String lastName,
			AsyncCallback<PersonDto> personCallback);

	void findAll(AsyncCallback<AbstractList<PersonDto>> personListCallback);

	// AbstractList<PersonDto> findSuggestions(String fullNameLike, int limit);
	void findSuggestions(String fullNameLike, int limit,
			AsyncCallback<AbstractList<PersonDto>> personListCallback);
}
