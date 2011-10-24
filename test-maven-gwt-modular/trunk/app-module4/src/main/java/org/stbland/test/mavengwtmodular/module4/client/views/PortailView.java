package org.stbland.test.mavengwtmodular.module4.client.views;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.IsWidget;

public interface PortailView extends IsWidget {

	public interface PortailPresenter {
		public void onLogoutButtonClicked();
	}

	void setPresenter(PortailPresenter presenter);

	HasClickHandlers getLogoutButton();
}
