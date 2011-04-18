package org.stbland.test_gwt_mvp.client.factory;

import org.stbland.test_gwt_mvp.client.views.home.HomeView;
import org.stbland.test_gwt_mvp.client.views.home.HomeViewImpl;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

public class ClientFactoryImpl implements ClientFactory {

	private EventBus eventBus;
	private PlaceController placeController;

	// Views
	private HomeView homeView;

	@Override
	public EventBus getEventBus() {
		if (eventBus == null) {
			eventBus = new SimpleEventBus();
		}
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		if (placeController == null) {
			placeController = new PlaceController(getEventBus());
		}
		return placeController;
	}

	@Override
	public HomeView getHomeView() {
		if (homeView == null) {
			homeView = new HomeViewImpl();
		}
		return homeView;
	}

}
