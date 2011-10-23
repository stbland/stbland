package org.stbland.test.mavengwtmodular.module3.client.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface AppBundle extends ClientBundle {
	// This is a very nasty workaround because GWT CssResource does not support
	// @media correctly!
	@Source("app.css")
	TextResource appCss();

	@Source("input.css")
	TextResource inputCss();

	public static final AppBundle INSTANCE = GWT.create(AppBundle.class);

}
