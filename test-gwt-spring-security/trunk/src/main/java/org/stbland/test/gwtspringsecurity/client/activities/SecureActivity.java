package org.stbland.test.gwtspringsecurity.client.activities;

import org.stbland.test.gwtspringsecurity.client.factory.ClientFactory;
import org.stbland.test.gwtspringsecurity.client.places.SecurePlace;
import org.stbland.test.gwtspringsecurity.client.views.SecureView;
import org.stbland.test.gwtspringsecurity.client.views.SecureView.Presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class SecureActivity extends AbstractActivity implements Presenter {

	private SecurePlace place;
	private ClientFactory clientFactory;

	public SecureActivity(SecurePlace place, ClientFactory clientFactory) {
		this.place = place;
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		SecureView secureView = clientFactory.getSecureView();
		secureView.setPresenter(this);
		containerWidget.setWidget(secureView.asWidget());
	}

}
