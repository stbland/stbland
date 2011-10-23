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
import com.googlecode.mgwt.dom.client.event.touch.simple.SimpleTouchEvent;
import com.googlecode.mgwt.dom.client.event.touch.simple.SimpleTouchHandler;

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
			loginView.setLoginPresenter(this);
			loginView.setBackButtonText("Menu");
			loginView.setTitle("Identification");

			addHandlerRegistration(loginView.getBackButton().addSimpleTouchHandler(
					new SimpleTouchHandler() {

						@Override
						public void onTouch(SimpleTouchEvent event) {
							clientFactory.getPlaceController().goTo(
									new MenuPlace());

						}
					}));

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