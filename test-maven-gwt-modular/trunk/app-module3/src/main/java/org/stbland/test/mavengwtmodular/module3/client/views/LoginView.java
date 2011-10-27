package org.stbland.test.mavengwtmodular.module3.client.views;

import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;

public interface LoginView extends ViewGwt {

	public interface LoginPresenter {
		public void onLoginButtonClicked();
	}

	void setLoginPresenter(LoginPresenter loginPresenter);

	HasSimpleTouchHandler getLoginButton();

	public void setTitle(String title);

	public void setBackButtonText(String text);

	public void setUuid(String uuid);

}
