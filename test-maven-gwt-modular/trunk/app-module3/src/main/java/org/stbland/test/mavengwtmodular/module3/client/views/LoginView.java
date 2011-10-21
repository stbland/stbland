package org.stbland.test.mavengwtmodular.module3.client.views;

import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;

public interface LoginView extends IsWidget {

	public interface LoginPresenter {
		public void onLoginButtonClicked();
	}

	void setLoginPresenter(LoginPresenter loginPresenter);

	HasSimpleTouchHandler getLoginButton();

}
