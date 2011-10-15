package org.stbland.testgwtp.server.guice;

import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.Injector;
import com.google.inject.Guice;
import org.stbland.testgwtp.server.guice.ServerModule;
import org.stbland.testgwtp.server.guice.DispatchServletModule;

public class GuiceServletConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice
				.createInjector(new ServerModule(), new DispatchServletModule());
	}
}
