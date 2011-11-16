package org.stbland.test.mavengwtmodular.module3.client.views;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

public interface MenuView extends PortailView {

	// TODO : public interface MenuPresenter extends
	// PortailView.PortailPresenter {
	public interface MenuPresenter extends PortailPresenter {
		public void onLogoutButtonClicked();

	}

	void setPresenter(MenuPresenter presenter);

	// TODO virer getLogoutButton
	HasTapHandlers getLogoutButton();

}
