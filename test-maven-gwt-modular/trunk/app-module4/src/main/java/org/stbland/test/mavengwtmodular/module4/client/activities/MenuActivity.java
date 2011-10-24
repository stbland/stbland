package org.stbland.test.mavengwtmodular.module4.client.activities;

import org.stbland.test.mavengwtmodular.module4.client.factory.PortailClientFactory;
import org.stbland.test.mavengwtmodular.module4.client.places.MenuPlace;
import org.stbland.test.mavengwtmodular.module4.client.views.MenuView;
import org.stbland.test.mavengwtmodular.module4.client.views.MenuView.MenuPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;


// public class MenuActivity extends AbstractPortailActivity implements	MenuPresenter {
public class MenuActivity extends AbstractActivity implements MenuPresenter {

	private MenuView menuView;

	public MenuActivity(PortailClientFactory clientFactory) {
		super(clientFactory);
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		Place place = clientFactory.getPlaceController().getWhere();

		if (place instanceof MenuPlace) {
			MenuPlace menuPlace = (MenuPlace) place;

			menuView = clientFactory.getMenuView();

			panel.setWidget(menuView);

		} else {
			Window.alert("MenuActivity: pas MenuPlace");
		}

	}

	@Override
	public void onLogoutButtonClicked() {
		// TODO Auto-generated method stub

	}

}
