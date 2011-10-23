package org.stbland.test.mavengwtmodular.module3.client.views.impl.menu;

import org.stbland.test.mavengwtmodular.module3.client.views.MenuView;
import org.stbland.test.mavengwtmodular.module3.client.views.impl.AbstractViewGwtImpl;

import com.google.gwt.uibinder.client.UiField;
import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;
import com.googlecode.mgwt.dom.client.event.touch.simple.SimpleTouchEvent;
import com.googlecode.mgwt.ui.client.widget.BarButton;


// public class MenuViewGwtImpl extends AbstractPortailView implements MenuView {
public class MenuViewGwtImpl extends AbstractViewGwtImpl implements MenuView {


	public MenuViewGwtImpl() {
		super();
//		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(MenuPresenter presenter) {
		// setPortailPresenter(menuPresenter);
		this.presenter = presenter;
	}

	// TODO debut block a virer

	private MenuPresenter presenter;

	@UiField
	protected BarButton logoutButton;

	// @Override
	/*
	public void setPortailPresenter(PortailPresenter presenter) {
		this.presenter = presenter;
	}
	*/

	@Override
	public HasSimpleTouchHandler getLogoutButton() {
		return logoutButton;
	}

	// @UiHandler("logoutButton")
	public void onSimpleTouch(SimpleTouchEvent event) {
		if (presenter != null) {
			presenter.onLogoutButtonClicked();
		}
	}

	// TODO debut block a virer

}
