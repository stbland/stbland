package org.stbland.testgwtp.client.view.mobile.gwtmobile;

import org.stbland.testgwtp.client.presenter.ContactPresenterBase.MyView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class ContactViewGwtMobileUiImpl extends GwtMobileUiViewImpl implements
		MyView {

	private static ContactViewGwtMobileUiImplUiBinder uiBinder = GWT
			.create(ContactViewGwtMobileUiImplUiBinder.class);

	interface ContactViewGwtMobileUiImplUiBinder extends
			UiBinder<Widget, ContactViewGwtMobileUiImpl> {
	}

	final private Widget widget;

	public ContactViewGwtMobileUiImpl() {
		widget = uiBinder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setNavigationHistory(String navigationHistory) {
		// this.navigationHistory.setText(navigationHistory);
	}

}
