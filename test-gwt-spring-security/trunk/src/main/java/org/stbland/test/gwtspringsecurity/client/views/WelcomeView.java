package org.stbland.test.gwtspringsecurity.client.views;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface WelcomeView extends IsWidget {

	void setPresenter(Presenter presenter);

	public interface Presenter {

		void goTo(Place newPlace);
	}

}
