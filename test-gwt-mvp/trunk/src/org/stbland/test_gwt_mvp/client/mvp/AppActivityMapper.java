package org.stbland.test_gwt_mvp.client.mvp;

import org.stbland.test_gwt_mvp.client.activities.HomeActivity;
import org.stbland.test_gwt_mvp.client.factory.ClientFactory;
import org.stbland.test_gwt_mvp.client.places.HomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof HomePlace) {
			return new HomeActivity((HomePlace) place, clientFactory);
		} else {
			return null;
		}
	}

}
