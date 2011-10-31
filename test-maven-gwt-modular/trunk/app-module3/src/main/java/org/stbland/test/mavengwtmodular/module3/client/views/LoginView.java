package org.stbland.test.mavengwtmodular.module3.client.views;

import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;

public interface LoginView extends ViewGwt {

	public interface LoginPresenter {
		public void onLoginButtonClicked();
	}

	void setLoginPresenter(LoginPresenter loginPresenter);

	HasSimpleTouchHandler getLoginButton();

	public void setLogin(String login);

	public String getLogin();
	
	public void focusLogin();

	public void setPassword(String password);

	public String getPassword();

	public void setUuid(String uuid);

	public String getUuid();

}
