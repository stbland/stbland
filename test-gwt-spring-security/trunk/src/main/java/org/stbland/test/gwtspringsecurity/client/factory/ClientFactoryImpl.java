package org.stbland.test.gwtspringsecurity.client.factory;

import org.stbland.test.gwtspringsecurity.client.views.LoginView;
import org.stbland.test.gwtspringsecurity.client.views.LoginViewImpl;
import org.stbland.test.gwtspringsecurity.client.views.WelcomeView;
import org.stbland.test.gwtspringsecurity.client.views.WelcomeViewImpl;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory {

	private EventBus eventBus;

	@Override
	public EventBus getEventBus() {
		if (eventBus == null) {
			eventBus = new SimpleEventBus();
		}
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return new PlaceController(getEventBus());
	}

	@Override
	public LoginView getLoginView() {
		return new LoginViewImpl();
	}

	@Override
	public WelcomeView getWelcomeView() {
		return new WelcomeViewImpl();
	}

}
