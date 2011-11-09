package org.stbland.test.gwtspringsecurity.client.views;

import com.google.gwt.user.client.ui.IsWidget;

public interface SecureView extends IsWidget {

	void setPresenter(Presenter presenter);

	public interface Presenter {
	}

}