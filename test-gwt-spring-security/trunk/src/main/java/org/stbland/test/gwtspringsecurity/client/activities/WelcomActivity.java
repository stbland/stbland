package org.stbland.test.gwtspringsecurity.client.activities;

import org.stbland.test.gwtspringsecurity.client.factory.ClientFactory;
import org.stbland.test.gwtspringsecurity.client.places.WelcomePlace;
import org.stbland.test.gwtspringsecurity.client.views.WelcomeView;
import org.stbland.test.gwtspringsecurity.client.views.WelcomeView.Presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class WelcomActivity extends AbstractActivity implements Presenter {

	private WelcomePlace place;
	private ClientFactory clientFactory;

	public WelcomActivity(WelcomePlace place, ClientFactory clientFactory) {
		this.place = place;
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		WelcomeView welcomeView = clientFactory.getWelcomeView();
		welcomeView.setPresenter(this);
		containerWidget.setWidget(welcomeView.asWidget());
	}

}
