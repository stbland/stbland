package org.stbland.test.mavengwtmodular.module3.client.views.impl.login;

import org.stbland.test.mavengwtmodular.module3.client.views.LoginView;
import org.stbland.test.mavengwtmodular.module3.client.views.impl.AbstractViewGwtImpl;

import com.google.gwt.user.client.ui.FlowPanel;
import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;
import com.googlecode.mgwt.dom.client.event.touch.simple.SimpleTouchEvent;
import com.googlecode.mgwt.dom.client.event.touch.simple.SimpleTouchHandler;
import com.googlecode.mgwt.ui.client.MGWTUtil;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.MPasswordTextBox;
import com.googlecode.mgwt.ui.client.widget.MTextBox;

public class LoginViewGwtImpl extends AbstractViewGwtImpl implements LoginView {

	private LoginPresenter presenter;

	protected Button loginButton;

	protected MTextBox loginTextBox;

	protected MTextBox uuidTextBox;

	protected MPasswordTextBox passwordTextBox;

	public LoginViewGwtImpl() {
		super();

		FlowPanel widgetList = new FlowPanel();
		// widgetList.setWidth("300px");
		// widgetList.setHeight("300px");
		widgetList.setHeight("90px");

		// WidgetList widgetList = new WidgetList();
		// widgetList.setRound(true);

		scrollPanel.setScrollingEnabledX(false);

		scrollPanel.setWidget(widgetList);
		// workaround for android formfields jumping around when using
		// -webkit-transform
		scrollPanel.setUsePos(MGWTUtil.getFeatureDetection().isAndroid());

		loginTextBox = new MTextBox();
		loginTextBox.setPlaceHolder("identifiant");
		widgetList.add(loginTextBox);

		uuidTextBox = new MTextBox();
		uuidTextBox.setPlaceHolder("UUID");
		uuidTextBox.setReadOnly(true);
		widgetList.add(uuidTextBox);

		passwordTextBox = new MPasswordTextBox();
		passwordTextBox.setPlaceHolder("mot de passe");
		widgetList.add(passwordTextBox);

		loginButton = new Button("Valider");
		widgetList.add(loginButton);

		loginButton.addSimpleTouchHandler(new SimpleTouchHandler() {

			@Override
			public void onTouch(SimpleTouchEvent event) {
				onSimpleTouch(event);

			}
		});

		main.add(scrollPanel);
		// main.add(loginButton);
	}

	@Override
	public void setUuid(String uuid) {
		uuidTextBox.setText(uuid);
	}

	@Override
	public void setTitle(String title) {
		headerPanel.setCenter(title);
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
	public HasSimpleTouchHandler getLoginButton() {
		return loginButton;
	}

	// @UiHandler("loginButton")
	public void onSimpleTouch(SimpleTouchEvent event) {
		// Window.alert("LoginButton clicked");
		if (presenter != null) {
			presenter.onLoginButtonClicked();
		}
	}

}
