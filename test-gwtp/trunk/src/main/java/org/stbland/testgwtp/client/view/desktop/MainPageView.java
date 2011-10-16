package org.stbland.testgwtp.client.view.desktop;

import org.stbland.testgwtp.client.presenter.MainPagePresenter;
import org.stbland.testgwtp.client.presenter.MainPagePresenter.MyView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

public class MainPageView extends ViewImpl implements MyView {
	interface MainPageViewUiBinder extends UiBinder<Widget, MainPageView> {
	}

	private static MainPageViewUiBinder uiBinder = GWT
			.create(MainPageViewUiBinder.class);

	public final Widget widget;

	@UiField
	FlowPanel mainContentPanel;

	@UiField
	Element loadingMessage;

	public MainPageView() {
		widget = uiBinder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == MainPagePresenter.TYPE_SetMainContent) {
			setMainContent(content);
		} else {
			super.setInSlot(slot, content);
		}
	}

	private void setMainContent(Widget content) {
		mainContentPanel.clear();

		if (content != null) {
			mainContentPanel.add(content);
		}
	}

	@Override
	public void showLoading(boolean visibile) {
		loadingMessage.getStyle().setVisibility(
				visibile ? Visibility.VISIBLE : Visibility.HIDDEN);
	}
}
