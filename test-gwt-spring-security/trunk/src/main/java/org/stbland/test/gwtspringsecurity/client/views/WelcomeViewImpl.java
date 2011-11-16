package org.stbland.test.gwtspringsecurity.client.views;

import org.stbland.test.gwtspringsecurity.client.places.LoginPlace;
import org.stbland.test.gwtspringsecurity.client.places.SecurePlace;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.SimplePanel;

public class WelcomeViewImpl extends Composite implements WelcomeView {

	private SimplePanel viewPanel = new SimplePanel();
	private Element nameSpan = DOM.createSpan();
	private MenuBar menuBar;

	private Presenter presenter;

	public WelcomeViewImpl() {
		nameSpan.setInnerText("Welcome");
		viewPanel.getElement().appendChild(nameSpan);

		Command loginCmd = new Command() {

			@Override
			public void execute() {
				presenter.goTo(new LoginPlace());

			}
		};

		Command secureCmd = new Command() {

			@Override
			public void execute() {
				presenter.goTo(new SecurePlace());

			}
		};

		menuBar = new MenuBar(true/* vertical */);
		menuBar.addItem("login", loginCmd);
		menuBar.addItem("secure", secureCmd);
		
		viewPanel.add(menuBar);

		initWidget(viewPanel);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

}
