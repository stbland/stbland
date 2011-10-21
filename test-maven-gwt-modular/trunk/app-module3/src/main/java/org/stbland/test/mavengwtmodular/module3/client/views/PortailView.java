package org.stbland.test.mavengwtmodular.module3.client.views;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;

public interface PortailView extends IsWidget {

	public interface PortailPresenter {
		public void onLogoutButtonClicked();
	}

	void setPresenter(PortailPresenter presenter);

	HasSimpleTouchHandler getLogoutButton();
}
