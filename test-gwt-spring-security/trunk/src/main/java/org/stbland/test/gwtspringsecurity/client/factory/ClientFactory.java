package org.stbland.test.gwtspringsecurity.client.factory;

import org.stbland.test.gwtspringsecurity.client.views.LoginView;
import org.stbland.test.gwtspringsecurity.client.views.WelcomeView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {

	EventBus getEventBus();

	PlaceController getPlaceController();

	LoginView getLoginView();

	WelcomeView getWelcomeView();

}
