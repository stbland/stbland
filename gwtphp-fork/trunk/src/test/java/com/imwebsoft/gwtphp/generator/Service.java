package com.imwebsoft.gwtphp.generator;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * @author mdinic
 * 
 */
public interface Service extends RemoteService {

	public String sayHi(String name);

	final public static String SERVICE_URI = "/Service";

	public static class Util {

		public static ServiceAsync getInstance() {

			ServiceAsync instance = (ServiceAsync) GWT.create(Service.class);
			ServiceDefTarget target = (ServiceDefTarget) instance;
			target.setServiceEntryPoint(GWT.getModuleBaseURL() + SERVICE_URI);
			return instance;

		}
	}
}
