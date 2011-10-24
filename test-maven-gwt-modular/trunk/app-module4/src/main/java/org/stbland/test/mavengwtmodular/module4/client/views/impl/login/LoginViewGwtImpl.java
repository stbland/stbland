package org.stbland.test.mavengwtmodular.module4.client.views.impl.login;

import org.stbland.test.mavengwtmodular.module4.client.views.LoginView;
import org.stbland.test.mavengwtmodular.module4.client.views.impl.AbstractViewGwtImpl;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.sksamuel.jqm4gwt.form.JQMSubmit;
import com.sksamuel.jqm4gwt.form.elements.JQMPassword;
import com.sksamuel.jqm4gwt.form.elements.JQMText;

public class LoginViewGwtImpl extends AbstractViewGwtImpl implements LoginView {

	private LoginPresenter presenter;

	protected JQMSubmit loginButton;

	protected JQMText loginTextBox;

	protected JQMPassword passwordTextBox;

	public LoginViewGwtImpl() {
		super("login");

		loginTextBox = new JQMText("identifiant");
		main.add(loginTextBox);

		passwordTextBox = new JQMPassword("mot de passe");
		main.add(passwordTextBox);

		loginButton = new JQMSubmit("Valider");
		main.add(loginButton);

		loginButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				onSimpleTouch(event);
			}
		});

	}

	@Override
	public void setTitle(String title) {
		headerPanel.setTitle(title);
	}

	@Override
	public void setBackButtonText(String text) {
		headerBackButton.setText(text);

	}

	@Override
	public void setLoginPresenter(LoginPresenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public HasClickHandlers getLoginButton() {
		return loginButton;
	}

	// @UiHandler("loginButton")
	public void onSimpleTouch(ClickEvent event) {
		// Window.alert("LoginButton clicked");
		if (presenter != null) {
			presenter.onLoginButtonClicked();
		}
	}

}
