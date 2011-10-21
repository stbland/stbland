package org.stbland.test.mavengwtmodular.module3.client.mappers.activity;

import org.stbland.test.mavengwtmodular.module3.client.factory.PortailClientFactory;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;


public class TabletActivityMapper extends AbstracPortailActivityMapper {

	public TabletActivityMapper(PortailClientFactory clientFactory) {
		super(clientFactory);
	}

	@Override
	public Activity getActivity(Place place) {
		return super.getActivity(place);
	}

}
