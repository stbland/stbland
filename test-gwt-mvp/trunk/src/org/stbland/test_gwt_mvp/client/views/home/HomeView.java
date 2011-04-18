package org.stbland.test_gwt_mvp.client.views.home;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface HomeView extends IsWidget {

	void setPresenter(Presenter presenter);

	public interface Presenter {
		void goTo(Place place);
	}
}
