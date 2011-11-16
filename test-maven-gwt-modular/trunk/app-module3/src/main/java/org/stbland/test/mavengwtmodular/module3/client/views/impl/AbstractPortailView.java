package org.stbland.test.mavengwtmodular.module3.client.views.impl;

import org.stbland.test.mavengwtmodular.module3.client.views.PortailView;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;

public abstract class AbstractPortailView extends AbstractViewGwtImpl implements
		PortailView {

	private PortailPresenter presenter;

	@UiField()
	protected HeaderButton logoutButton;

	@Override
	public void setPresenter(PortailPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public HasTapHandlers getLogoutButton() {
		return logoutButton;
	}

	@UiHandler("logoutButton")
	public void onSimpleTouch(HasTapHandlers event) {
		if (presenter != null) {
			presenter.onLogoutButtonClicked();
		}
	}

}
