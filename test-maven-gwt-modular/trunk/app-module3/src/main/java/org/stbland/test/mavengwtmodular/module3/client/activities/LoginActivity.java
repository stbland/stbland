package org.stbland.test.mavengwtmodular.module3.client.activities;

import org.stbland.test.mavengwtmodular.module3.client.factory.PortailClientFactory;
import org.stbland.test.mavengwtmodular.module3.client.places.LoginPlace;
import org.stbland.test.mavengwtmodular.module3.client.places.MenuPlace;
import org.stbland.test.mavengwtmodular.module3.client.views.LoginView;
import org.stbland.test.mavengwtmodular.module3.client.views.LoginView.LoginPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;


public class LoginActivity extends AbstractActivity implements LoginPresenter {

	private LoginView loginView;

	public LoginActivity(PortailClientFactory clientFactory) {
		super(clientFactory);
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Place place = clientFactory.getPlaceController().getWhere();

		if (place instanceof LoginPlace) {
			LoginPlace loginPlace = (LoginPlace) place;

			loginView = clientFactory.getLoginView();

			panel.setWidget(loginView);

		} else {
			Window.alert("LoginActivity: pas LoginPlace");
		}
	}

	@Override
	public void onLoginButtonClicked() {
		// TODO contrôler le login
		clientFactory.getPlaceController().goTo(new MenuPlace());

	}
}