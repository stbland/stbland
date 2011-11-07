package org.stbland.test.gwtspringsecurity.client.activities;

import org.stbland.test.gwtspringsecurity.client.factory.ClientFactory;
import org.stbland.test.gwtspringsecurity.client.places.LoginPlace;
import org.stbland.test.gwtspringsecurity.client.views.LoginView;
import org.stbland.test.gwtspringsecurity.client.views.LoginView.Presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class LoginActivity extends AbstractActivity implements Presenter {

	private LoginPlace place;
	private ClientFactory clientFactory;

	public LoginActivity(LoginPlace place, ClientFactory clientFactory) {
		this.place = place;
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		LoginView loginView = clientFactory.getLoginView();
		loginView.setPresenter(this);
		containerWidget.setWidget(loginView.asWidget());
	}

}