package org.stbland.test.mavengwtmodular.module3.client.views.impl.login;

import org.stbland.test.mavengwtmodular.module3.client.views.LoginView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;
import com.googlecode.mgwt.dom.client.event.touch.simple.SimpleTouchEvent;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.MPasswordTextBox;
import com.googlecode.mgwt.ui.client.widget.MTextBox;

public class LoginViewGwtImpl extends Composite implements LoginView {

	interface LoginViewGwtImplUiBinder extends
			UiBinder<Widget, LoginViewGwtImpl> {
	}

	private static LoginViewGwtImplUiBinder uiBinder = GWT
			.create(LoginViewGwtImplUiBinder.class);

	private LoginPresenter loginPresenter;

	@UiField
	protected Button loginButton;

	@UiField
	protected MTextBox loginTextBox;

	@UiField
	protected MPasswordTextBox passwordTextBox;

	public LoginViewGwtImpl() {
		super();
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setLoginPresenter(LoginPresenter loginPresenter) {
		this.loginPresenter = loginPresenter;
	}

	@Override
	public HasSimpleTouchHandler getLoginButton() {
		return loginButton;
	}

	@UiHandler("loginButton")
	public void onSimpleTouch(SimpleTouchEvent event) {
		if (loginPresenter != null) {
			loginPresenter.onLoginButtonClicked();
		}
	}
}
