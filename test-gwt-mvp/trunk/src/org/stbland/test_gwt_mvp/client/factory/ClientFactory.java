package org.stbland.test_gwt_mvp.client.factory;

import org.stbland.test_gwt_mvp.client.views.home.HomeView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;

public interface ClientFactory {

	public EventBus getEventBus();

	public PlaceController getPlaceController();

	public HomeView getHomeView();

}
