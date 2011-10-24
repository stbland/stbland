package org.stbland.test.mavengwtmodular.module4.client.views.impl;

import org.stbland.test.mavengwtmodular.module4.client.views.PortailView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.sksamuel.jqm4gwt.button.JQMButton;

public abstract class AbstractPortailView extends AbstractViewGwtImpl implements
		PortailView {

	public AbstractPortailView(String pageId) {
		super(pageId);
	}

	private PortailPresenter presenter;

	// @UiField()
	protected JQMButton logoutButton;

	@Override
	public void setPresenter(PortailPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public HasClickHandlers getLogoutButton() {
		return logoutButton;
	}

	// @UiHandler("logoutButton")
	public void onSimpleTouch(ClickEvent event) {
		if (presenter != null) {
			presenter.onLogoutButtonClicked();
		}
	}

}
