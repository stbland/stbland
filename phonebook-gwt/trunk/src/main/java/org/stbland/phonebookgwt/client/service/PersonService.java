package org.stbland.phonebookgwt.client.service;

import java.util.AbstractList;

import org.stbland.phonebookgwt.bean.PersonDto;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("person")
public interface PersonService extends RemoteService {

	PersonDto find(String firstName, String lastName);

	AbstractList<PersonDto> findAll();

	AbstractList<PersonDto> findSuggestions(String fullNameLike, int limit);
}
