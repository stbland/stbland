package org.stbland.test.gwtspringsecurity.client;

import org.stbland.test.gwtspringsecurity.client.factory.ClientFactory;
import org.stbland.test.gwtspringsecurity.client.mappers.AppActivityMapper;
import org.stbland.test.gwtspringsecurity.client.mappers.AppPlaceHistoryMapper;
import org.stbland.test.gwtspringsecurity.client.places.WelcomePlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

public class MainModuleEntryPoint  implements EntryPoint{

	 private Place defaultPlace = new WelcomePlace();
	    private SimplePanel appWidget = new SimplePanel();

	    public void onModuleLoad() {
	        ClientFactory clientFactory = GWT.create(ClientFactory.class);
	        EventBus eventBus = clientFactory.getEventBus();
	        PlaceController placeController = clientFactory.getPlaceController();

	        // Start ActivityManager for the main widget with our ActivityMapper
	        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
	        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
	        activityManager.setDisplay(appWidget);

	        // Start PlaceHistoryHandler with our PlaceHistoryMapper
	        AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
	        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
	        historyHandler.register(placeController, eventBus, defaultPlace);

	        RootPanel.get().add(appWidget);
	        // Goes to the place represented on URL else default place
	        historyHandler.handleCurrentHistory();
	    }		
	

}
