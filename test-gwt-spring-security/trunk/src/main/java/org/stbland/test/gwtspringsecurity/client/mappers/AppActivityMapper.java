package org.stbland.test.gwtspringsecurity.client.mappers;

import org.springframework.security.access.annotation.Secured;
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
import com.google.gwt.user.client.Window;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		Activity activity = null;

		// if (place instanceof Secured ) {
		// @see http://code.google.com/p/google-web-toolkit/source/browse/trunk/user/src/com/google/gwt/place/rebind/PlaceHistoryMapperGenerator.java?r=9603
		Secured securedAnnotation = null; // place.getClass().getAnnotation(	Secured.class);
		// if (place.getClass().isAnnotationPresent(Secured.class)) {
		if (securedAnnotation != null) {
			Window.alert("secured activity");
			return activity;
		}

		if (place instanceof WelcomePlace) {
			activity = new WelcomActivity((WelcomePlace) place, clientFactory);
		} else if (place instanceof LoginPlace) {
			activity = new LoginActivity((LoginPlace) place, clientFactory);
		} else if (place instanceof SecurePlace) {
			activity = new SecureActivity((SecurePlace) place, clientFactory);
		}

		return activity;
	}

}
