package org.stbland.test_gwt_mvp.client;

import org.stbland.test_gwt_mvp.client.factory.ClientFactory;
import org.stbland.test_gwt_mvp.client.factory.ClientFactoryImpl;
import org.stbland.test_gwt_mvp.client.mvp.AppActivityMapper;
import org.stbland.test_gwt_mvp.client.mvp.AppPlaceHistoryMapper;
import org.stbland.test_gwt_mvp.client.places.HomePlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class EntryPoint1 implements EntryPoint {

	private Place defaultPlace = new HomePlace(null);
	private SimplePanel appWidget = new SimplePanel();

	@Override
	public void onModuleLoad() {
		// Create ClientFactory using deferred binding so we can replace with
		// different
		// impls in gwt.xml
		// ClientFactory clientFactory = GWT.create(ClientFactory.class);
		ClientFactory clientFactory = new ClientFactoryImpl();
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();

		// Start ActivityManager for the main widget with our ActivityMapper
		ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		ActivityManager activityManager = new ActivityManager(activityMapper,
				eventBus);
		activityManager.setDisplay(appWidget);

		// Start PlaceHistoryHandler with our PlaceHistoryMapper
		AppPlaceHistoryMapper historyMapper = GWT
				.create(AppPlaceHistoryMapper.class);

		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootPanel.get().add(appWidget);
		// Goes to place represented on URL or default place
		historyHandler.handleCurrentHistory();

	}

}
