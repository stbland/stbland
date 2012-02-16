package org.stbland.testgwtjquerymobile.client.mappers;

import org.stbland.testgwtjquerymobile.client.activities.WelcomeActivity;
import org.stbland.testgwtjquerymobile.client.factory.ClientFactory;
import org.stbland.testgwtjquerymobile.client.places.WelcomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof WelcomePlace) {
			return new WelcomeActivity(place, clientFactory);
		}
		return null;
	}

}
