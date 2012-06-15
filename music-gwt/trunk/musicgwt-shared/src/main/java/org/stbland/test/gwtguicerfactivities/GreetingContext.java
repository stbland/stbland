package org.stbland.test.gwtguicerfactivities;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

/**
 * The client side stub for the RequestFactory service.
 */
@ServiceName(value="org.stbland.test.gwtguicerfactivities.GreetingService", locator="org.stbland.test.gwtguicerfactivities.GuiceServiceLocator")
public interface GreetingContext extends RequestContext {
	Request<GreetingResponseProxy> greetServer(String name);
}
