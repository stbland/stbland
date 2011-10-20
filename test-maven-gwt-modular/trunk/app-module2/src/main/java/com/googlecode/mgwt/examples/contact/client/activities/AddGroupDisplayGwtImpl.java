package com.googlecode.mgwt.examples.contact.client.activities;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.touch.simple.SimpleTouchEvent;
import com.googlecode.mgwt.ui.client.MGWTStyle;
import com.googlecode.mgwt.ui.client.MGWTUtil;
import com.googlecode.mgwt.ui.client.dialog.Dialogs;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.HeaderButton;
import com.googlecode.mgwt.ui.client.widget.MTextBox;

public class AddGroupDisplayGwtImpl extends Composite implements AddGroupDisplay {

	private static AddGroupDisplayGwtImplUiBinder uiBinder = GWT.create(AddGroupDisplayGwtImplUiBinder.class);

	@UiField
	protected HeaderButton leftButton;

	@UiField
	protected Button addButton;

	@UiField
	protected MTextBox groupName;

	private Presenter presenter;

	interface AddGroupDisplayGwtImplUiBinder extends UiBinder<Widget, AddGroupDisplayGwtImpl> {
	}

	public AddGroupDisplayGwtImpl() {
		initWidget(uiBinder.createAndBindUi(this));

		if (!MGWTUtil.getFeatureDetection().isPhone()) {
			leftButton.setText("Nav");
			leftButton.setRoundButton(true);
			leftButton.addStyleName(MGWTStyle.getDefaultClientBundle().getUtilCss().portraitonly());
		}
	}

	@UiHandler("leftButton")
	protected void onLeftButtonClicked(SimpleTouchEvent event) {
		if (presenter != null) {
			presenter.onLeftButton();
		}
	}

	@UiHandler("addButton")
	protected void onAddButtonClicked(SimpleTouchEvent event) {
		if (presenter != null) {
			presenter.onAddButtonPressed();
		}
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public HasText getGroupName() {
		return groupName;
	}

	@Override
	public void showError(String string) {
		Dialogs.alert("Error", string, null);

	}

}
