package org.stbland.testgwtjquerymobile.client.factory.impl;

import org.stbland.testgwtjquerymobile.client.factory.ClientFactory;
import org.stbland.testgwtjquerymobile.client.views.WelcomeView;
import org.stbland.testgwtjquerymobile.client.views.impl.WelcomeViewImpl;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory {

	private final EventBus eventBus = new SimpleEventBus();
	private final PlaceController placeController = new PlaceController(
			eventBus);
	private WelcomeView welcomeView;

	public EventBus getEventBus() {
		return eventBus;
	}

	public PlaceController getPlaceController() {
		return placeController;
	}

	public WelcomeView geWelcomeView() {
		if (welcomeView == null) {
			welcomeView = new WelcomeViewImpl();
		}
		return welcomeView;
	}
}
