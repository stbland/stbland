package org.stbland.test.mavengwtmodular.module4.client.activities;

import org.stbland.test.mavengwtmodular.module4.client.factory.PortailClientFactory;
import org.stbland.test.mavengwtmodular.module4.client.places.LoginPlace;
import org.stbland.test.mavengwtmodular.module4.client.views.PortailView.PortailPresenter;

public abstract class AbstractPortailActivity extends AbstractActivity
		implements PortailPresenter {


	public AbstractPortailActivity(PortailClientFactory clientFactory) {
		super(clientFactory);
	}
	
	@Override
	public void onLogoutButtonClicked() {
		// TODO effectuer la déconnexion
		clientFactory.getPlaceController().goTo(new LoginPlace());

	}
}
