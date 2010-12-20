package org.stbland.phonebookgwt.client.service;

import org.stbland.phonebookgwt.bean.PhoneDto;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>PhoneService</code>.
 */
public interface PhoneServiceAsync {
	void findPhone(String personName, AsyncCallback<PhoneDto> callback)
			throws IllegalArgumentException;
}