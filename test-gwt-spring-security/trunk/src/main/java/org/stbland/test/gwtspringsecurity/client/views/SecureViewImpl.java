package org.stbland.test.gwtspringsecurity.client.views;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

public class SecureViewImpl extends Composite implements SecureView {

	private SimplePanel viewPanel = new SimplePanel();
	private Element nameSpan = DOM.createSpan();
	private Presenter presenter;

	public SecureViewImpl() {
		nameSpan.setInnerText("Secure");
		viewPanel.getElement().appendChild(nameSpan);
		initWidget(viewPanel);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

}
