package org.stbland.testgwtjquerymobile.client.factory;

import org.stbland.testgwtjquerymobile.client.views.WelcomeView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
	EventBus getEventBus();

	PlaceController getPlaceController();

	WelcomeView geWelcomeView();

}