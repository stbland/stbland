package org.stbland.test.gwtspringsecurity.client.mappers;

import org.stbland.test.gwtspringsecurity.client.activities.LoginActivity;
import org.stbland.test.gwtspringsecurity.client.activities.SecureActivity;
import org.stbland.test.gwtspringsecurity.client.activities.WelcomActivity;
import org.stbland.test.gwtspringsecurity.client.factory.ClientFactory;
import org.stbland.test.gwtspringsecurity.client.places.LoginPlace;
import org.stbland.test.gwtspringsecurity.client.places.SecurePlace;
import org.stbland.test.gwtspringsecurity.client.places.WelcomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof WelcomePlace)
			return new WelcomActivity((WelcomePlace) place, clientFactory);
		else if (place instanceof LoginPlace)
			return new LoginActivity((LoginPlace) place, clientFactory);
		else if (place instanceof SecurePlace)
			return new SecureActivity((SecurePlace) place, clientFactory);
		return null;
	}

}
