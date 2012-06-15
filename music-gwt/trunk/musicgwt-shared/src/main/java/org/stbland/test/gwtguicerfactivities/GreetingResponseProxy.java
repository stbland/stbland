package org.stbland.test.gwtguicerfactivities;

import com.google.web.bindery.requestfactory.shared.ProxyForName;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyForName("org.stbland.test.gwtguicerfactivities.GreetingResponse")
interface GreetingResponseProxy extends ValueProxy {
	
	boolean isSuccessful();

	String getError();
	
	String getGreeting();

	String getServerInfo();

	String getUserAgent();
}