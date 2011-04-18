package org.stbland.test_gwt_mvp.client.activities;

import org.stbland.test_gwt_mvp.client.factory.ClientFactory;
import org.stbland.test_gwt_mvp.client.places.HomePlace;
import org.stbland.test_gwt_mvp.client.views.home.HomeView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HomeActivity extends AbstractActivity implements
		HomeView.Presenter {

	private ClientFactory clientFactory;

	public HomeActivity(HomePlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		 HomeView homeView = clientFactory.getHomeView();
         homeView.setPresenter(this);
         panel.setWidget(homeView.asWidget());

	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);

	}

}
