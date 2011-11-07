package org.stbland.test.gwtspringsecurity.client.views;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

public class LoginViewImpl extends Composite implements LoginView {

	private SimplePanel viewPanel = new SimplePanel();
	private Element nameSpan = DOM.createSpan();
	private Presenter presenter;

	public LoginViewImpl() {
		nameSpan.setInnerText("Login");
		viewPanel.getElement().appendChild(nameSpan);
		initWidget(viewPanel);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

}
