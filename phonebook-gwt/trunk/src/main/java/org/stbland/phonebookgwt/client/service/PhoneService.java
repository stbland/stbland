package org.stbland.phonebookgwt.client.service;

import org.stbland.phonebookgwt.bean.PhoneDto;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("phone")
public interface PhoneService extends RemoteService {
	PhoneDto findPhone(String personName) throws IllegalArgumentException;
}
