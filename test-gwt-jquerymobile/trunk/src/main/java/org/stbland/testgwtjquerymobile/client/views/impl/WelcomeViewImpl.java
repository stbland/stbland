package org.stbland.testgwtjquerymobile.client.views.impl;

import org.stbland.testgwtjquerymobile.client.views.WelcomeView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class WelcomeViewImpl extends Composite implements WelcomeView {

	public interface WelcomeViewImplUiBinder extends
			UiBinder<Widget, WelcomeViewImpl> {
	}

	private static WelcomeViewImplUiBinder uiBinder = GWT
			.create(WelcomeViewImplUiBinder.class);

	private Presenter presenter;

	public WelcomeViewImpl() {
		// super();
		initWidget(uiBinder.createAndBindUi(this));
		// setElement(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public Presenter getPresenter() {
		return presenter;
	}

}
