package org.stbland.test.mavengwtmodular.module3.client.views.impl.menu;

import org.stbland.test.mavengwtmodular.module3.client.views.MenuView;
import org.stbland.test.mavengwtmodular.module3.client.views.impl.AbstractPortailView;

import com.google.gwt.uibinder.client.UiField;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;

public class MenuViewGwtImpl extends AbstractPortailView implements MenuView {

	public MenuViewGwtImpl() {
		super();
		// initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(MenuPresenter presenter) {
		// setPortailPresenter(menuPresenter);
		this.presenter = presenter;
	}

	// TODO debut block a virer

	private MenuPresenter presenter;

	@UiField
	protected HeaderButton logoutButton;

	// @Override
	/*
	 * public void setPortailPresenter(PortailPresenter presenter) {
	 * this.presenter = presenter; }
	 */

	@Override
	public HasTapHandlers getLogoutButton() {
		return logoutButton;
	}

	// @UiHandler("logoutButton")
	public void onSimpleTouch(TapEvent event) {
		if (presenter != null) {
			presenter.onLogoutButtonClicked();
		}
	}

	// TODO debut block a virer

}
