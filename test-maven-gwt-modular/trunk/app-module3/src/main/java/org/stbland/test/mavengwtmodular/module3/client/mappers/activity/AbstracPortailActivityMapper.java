package org.stbland.test.mavengwtmodular.module3.client.mappers.activity;

import org.stbland.test.mavengwtmodular.module3.client.activities.LoginActivity;
import org.stbland.test.mavengwtmodular.module3.client.activities.MenuActivity;
import org.stbland.test.mavengwtmodular.module3.client.factory.PortailClientFactory;
import org.stbland.test.mavengwtmodular.module3.client.places.LoginPlace;
import org.stbland.test.mavengwtmodular.module3.client.places.MenuPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;


public abstract class AbstracPortailActivityMapper implements ActivityMapper {

	private final PortailClientFactory clientFactory;

	private LoginActivity loginActivity;
	private MenuActivity menuActivity;

	public AbstracPortailActivityMapper(PortailClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof MenuPlace) {
			return getMenuActivity();
		}

		if (place instanceof LoginPlace) {
			return getLoginActivity();
		}
		return null;
	}

	protected Activity getMenuActivity() {
		if (menuActivity == null) {
			menuActivity = new MenuActivity(clientFactory);
		}
		return menuActivity;
	}

	protected Activity getLoginActivity() {
		if (loginActivity == null) {
			loginActivity = new LoginActivity(clientFactory);
		}
		return loginActivity;
	}
}
