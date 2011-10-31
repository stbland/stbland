package org.stbland.test.mavengwtmodular.module3.client.views.impl;

import org.stbland.test.mavengwtmodular.module3.client.views.PortailView;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;
import com.googlecode.mgwt.dom.client.event.touch.simple.SimpleTouchEvent;
import com.googlecode.mgwt.ui.client.widget.BarButton;

public abstract class AbstractPortailView extends AbstractViewGwtImpl implements
		PortailView {

	private PortailPresenter presenter;

	@UiField()
	protected BarButton logoutButton;

	@Override
	public void setPresenter(PortailPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public HasSimpleTouchHandler getLogoutButton() {
		return logoutButton;
	}

	@UiHandler("logoutButton")
	public void onSimpleTouch(SimpleTouchEvent event) {
		if (presenter != null) {
			presenter.onLogoutButtonClicked();
		}
	}

}
