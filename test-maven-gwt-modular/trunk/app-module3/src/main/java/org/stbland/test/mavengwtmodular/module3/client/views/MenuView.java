package org.stbland.test.mavengwtmodular.module3.client.views;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;

// public interface MenuView extends PortailView {
public interface MenuView extends IsWidget {

	// TODO : public interface MenuPresenter extends PortailView.PortailPresenter {
	public interface MenuPresenter {
		public void onLogoutButtonClicked();

	}

	void setPresenter(MenuPresenter presenter);
	
	// TODO virer getLogoutButton
	HasSimpleTouchHandler getLogoutButton();

}
