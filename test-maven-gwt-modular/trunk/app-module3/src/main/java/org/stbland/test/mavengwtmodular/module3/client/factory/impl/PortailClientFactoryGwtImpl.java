package org.stbland.test.mavengwtmodular.module3.client.factory.impl;

import org.stbland.test.mavengwtmodular.module3.client.factory.PortailClientFactory;
import org.stbland.test.mavengwtmodular.module3.client.views.LoginView;
import org.stbland.test.mavengwtmodular.module3.client.views.MenuView;
import org.stbland.test.mavengwtmodular.module3.client.views.impl.login.LoginViewGwtImpl;
import org.stbland.test.mavengwtmodular.module3.client.views.impl.menu.MenuViewGwtImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;

public class PortailClientFactoryGwtImpl implements PortailClientFactory {

	private PlaceController placeController;
	private SimpleEventBus eventBus;
	private MenuView menuView;
	private LoginView loginView;
	private PhoneGap phoneGap;

	@Override
	public PlaceController getPlaceController() {
		if (placeController == null) {
			placeController = new PlaceController(getEventBus());
		}
		return placeController;
	}

	@Override
	public EventBus getEventBus() {
		if (eventBus == null) {
			eventBus = new SimpleEventBus();
		}
		return eventBus;
	}

	@Override
	public MenuView getMenuView() {
		if (menuView == null) {
			// menuView = new MenuViewGwtUiBinderImpl();
			menuView = new MenuViewGwtImpl();
		}
		return menuView;
	}

	@Override
	public LoginView getLoginView() {
		if (loginView == null) {
			// loginView = new LoginViewUiBinderImpl();
			loginView = new LoginViewGwtImpl();
		}
		return loginView;
	}

	@Override
	public PhoneGap getPhoneGap() {
		if (phoneGap == null) {
			phoneGap = (PhoneGap) GWT.create(PhoneGap.class);
		}
		return phoneGap;
	}

}
