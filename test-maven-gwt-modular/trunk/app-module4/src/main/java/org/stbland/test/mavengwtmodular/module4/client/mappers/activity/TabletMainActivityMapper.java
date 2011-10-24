package org.stbland.test.mavengwtmodular.module4.client.mappers.activity;

import org.stbland.test.mavengwtmodular.module4.client.factory.PortailClientFactory;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;


public class TabletMainActivityMapper extends AbstracPortailActivityMapper {

	public TabletMainActivityMapper(PortailClientFactory clientFactory) {
		super(clientFactory);
	}

	@Override
	public Activity getActivity(Place place) {
		return super.getActivity(place);
	}

}
