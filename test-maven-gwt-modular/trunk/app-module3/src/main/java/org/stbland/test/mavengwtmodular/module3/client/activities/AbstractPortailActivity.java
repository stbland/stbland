package org.stbland.test.mavengwtmodular.module3.client.activities;

import org.stbland.test.mavengwtmodular.module3.client.factory.PortailClientFactory;
import org.stbland.test.mavengwtmodular.module3.client.places.LoginPlace;
import org.stbland.test.mavengwtmodular.module3.client.views.PortailView.PortailPresenter;

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
