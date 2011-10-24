package org.stbland.test.mavengwtmodular.module4.client.views;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.IsWidget;

// public interface MenuView extends PortailView {
public interface MenuView extends IsWidget {

	// TODO : public interface MenuPresenter extends
	// PortailView.PortailPresenter {
	public interface MenuPresenter {
		public void onLogoutButtonClicked();

	}

	void setPresenter(MenuPresenter presenter);

	// TODO virer getLogoutButton
	HasClickHandlers getLogoutButton();

}
