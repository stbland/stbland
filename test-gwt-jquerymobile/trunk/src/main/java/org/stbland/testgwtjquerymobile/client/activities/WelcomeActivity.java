package org.stbland.testgwtjquerymobile.client.activities;

import org.stbland.testgwtjquerymobile.client.factory.ClientFactory;
import org.stbland.testgwtjquerymobile.client.views.WelcomeView;
import org.stbland.testgwtjquerymobile.client.views.WelcomeView.Presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class WelcomeActivity extends AbstractActivity implements Presenter {

	private ClientFactory clientFactory;
	private WelcomeView welcomeView;

	public WelcomeActivity(Place place, ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		welcomeView = clientFactory.geWelcomeView();
		welcomeView.setPresenter(this);
		containerWidget.setWidget(welcomeView.asWidget());
	}

}
