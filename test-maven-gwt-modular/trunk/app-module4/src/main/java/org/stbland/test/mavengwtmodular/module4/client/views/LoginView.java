package org.stbland.test.mavengwtmodular.module4.client.views;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface LoginView extends ViewGwt {

	public interface LoginPresenter {
		public void onLoginButtonClicked();
	}

	void setLoginPresenter(LoginPresenter loginPresenter);

	HasClickHandlers getLoginButton();

	public void setTitle(String title);

	public void setBackButtonText(String text);

}
