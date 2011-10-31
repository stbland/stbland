package org.stbland.test.mavengwtmodular.module3.client.views;

import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;

public interface PortailView extends ViewGwt {

	public interface PortailPresenter {
		public void onLogoutButtonClicked();
	}

	void setPresenter(PortailPresenter presenter);

	HasSimpleTouchHandler getLogoutButton();
}
