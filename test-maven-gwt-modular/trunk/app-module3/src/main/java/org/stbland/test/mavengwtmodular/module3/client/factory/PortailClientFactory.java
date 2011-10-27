package org.stbland.test.mavengwtmodular.module3.client.factory;

import org.stbland.test.mavengwtmodular.module3.client.views.LoginView;
import org.stbland.test.mavengwtmodular.module3.client.views.MenuView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;


public interface PortailClientFactory {

	PlaceController getPlaceController();

	EventBus getEventBus();
	
	PhoneGap getPhoneGap();

	LoginView getLoginView();

	MenuView getMenuView();

}
