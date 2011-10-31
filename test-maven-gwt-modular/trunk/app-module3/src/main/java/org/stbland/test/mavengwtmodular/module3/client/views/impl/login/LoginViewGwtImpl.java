package org.stbland.test.mavengwtmodular.module3.client.views.impl.login;

import org.stbland.test.mavengwtmodular.module3.client.views.LoginView;
import org.stbland.test.mavengwtmodular.module3.client.views.impl.AbstractViewGwtImpl;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Widget;
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

	// protected MTextBox uuidTextBox;
	protected Hidden uuidTextBox;

	protected MPasswordTextBox passwordTextBox;

	private FlowPanel widgetList;

	public LoginViewGwtImpl() {
		super();

		widgetList = new FlowPanel();
		// widgetList.setWidth("300px");
		// widgetList.setHeight("300px");
		// widgetList.setHeight("90px");

		// WidgetList widgetList = new WidgetList();
		// widgetList.setRound(true);

		scrollPanel.setScrollingEnabledX(false);

		scrollPanel.setWidget(widgetList);
		// workaround for android formfields jumping around when using
		// -webkit-transform
		scrollPanel.setUsePos(MGWTUtil.getFeatureDetection().isAndroid());

		FlexTable table = new FlexTable();
		table.setHeight("90px");
		widgetList.add(table);

		table.setText(0/* row */, 0/* column */, "Identifiant");
		table.setText(1/* row */, 0/* column */, "Mot de passe");

		// Label loginLabel = new Label("Identifiant: ");
		// widgetListAdd(loginLabel);

		loginTextBox = new MTextBox();
		loginTextBox.setPlaceHolder("identifiant");
		// widgetListAdd(loginTextBox);
		table.setWidget(0/* row */, 1/* column */, loginTextBox);

		/*
		 * uuidTextBox = new MTextBox(); uuidTextBox.setPlaceHolder("UUID");
		 * uuidTextBox.setReadOnly(true);
		 */
		uuidTextBox = new Hidden("uuid");
		widgetListAdd(uuidTextBox);

		passwordTextBox = new MPasswordTextBox();
		passwordTextBox.setPlaceHolder("mot de passe");
		// widgetListAdd(passwordTextBox);
		table.setWidget(1/* row */, 1/* column */, passwordTextBox);

		loginButton = new Button("Valider");
		// widgetListAdd(loginButton);
		table.setWidget(2/* row */, 1/* column */, loginButton);

		loginButton.addSimpleTouchHandler(new SimpleTouchHandler() {

			@Override
			public void onTouch(SimpleTouchEvent event) {
				onSimpleTouch(event);

			}
		});

		main.add(scrollPanel);
		// main.add(loginButton);
	}

	private void widgetListAdd(Widget widget) {
		widget.setHeight("30px");
		widgetList.add(widget);
	}

	@Override
	public void setUuid(String uuid) {
		// uuidTextBox.setText(uuid);
		uuidTextBox.setValue(uuid);
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

	@Override
	public void setLogin(String login) {
		loginTextBox.setText(login);

	}

	@Override
	public String getLogin() {
		return loginTextBox.getText();
	}

	@Override
	public void focusLogin() {
		loginTextBox.selectAll();
	}

	@Override
	public void setPassword(String password) {
		passwordTextBox.setText(password);

	}

	@Override
	public String getPassword() {
		return passwordTextBox.getText();
	}

	@Override
	public String getUuid() {
		return uuidTextBox.getValue();
	}

}
