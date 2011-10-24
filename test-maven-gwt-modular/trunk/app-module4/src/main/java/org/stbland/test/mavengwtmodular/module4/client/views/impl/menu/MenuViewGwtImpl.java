package org.stbland.test.mavengwtmodular.module4.client.views.impl.menu;

import org.stbland.test.mavengwtmodular.module4.client.views.MenuView;
import org.stbland.test.mavengwtmodular.module4.client.views.impl.AbstractViewGwtImpl;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.sksamuel.jqm4gwt.button.JQMButton;

// public class MenuViewGwtImpl extends AbstractPortailView implements MenuView {
public class MenuViewGwtImpl extends AbstractViewGwtImpl implements MenuView {

	public MenuViewGwtImpl() {
		super("menu");
		// initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(MenuPresenter presenter) {
		// setPortailPresenter(menuPresenter);
		this.presenter = presenter;
	}

	// TODO debut block a virer

	private MenuPresenter presenter;

	// @UiField
	protected JQMButton logoutButton;

	// @Override
	/*
	 * public void setPortailPresenter(PortailPresenter presenter) {
	 * this.presenter = presenter; }
	 */

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

	// TODO debut block a virer

}
