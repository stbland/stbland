package org.stbland.test.mavengwtmodular.module2.client;

import org.stbland.test.mavengwtmodular.module1.client.MyButton;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;

public class Module2EntryPoint implements EntryPoint {

	private Button module1Button;
	private Button uuidPhoneGapButton, vibratePhoneGapButton;
	private PhoneGap phoneGap;

	@Override
	public void onModuleLoad() {
		showDebug("onModuleLoad");

		initUi();
		initPhoneGap();

	}

	private void initPhoneGap() {
		phoneGap = GWT.create(PhoneGap.class);

		phoneGap.addHandler(new PhoneGapAvailableHandler() {

			@Override
			public void onPhoneGapAvailable(PhoneGapAvailableEvent event) {
				showDebug("onPhoneGapAvailable");

				uuidPhoneGapButton.setEnabled(true);
				vibratePhoneGapButton.setEnabled(true);
			}
		});

		phoneGap.addHandler(new PhoneGapTimeoutHandler() {

			@Override
			public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
				showError("onPhoneGapTimeout");

			}
		});

		phoneGap.initializePhoneGap();
	}

	private void initUi() {
		module1Button = new MyButton("Button Module 1", new ClickHandler() {
			public void onClick(ClickEvent event) {
				showInfo("Module 2 OK");
			}
		});

		uuidPhoneGapButton = new MyButton("UUID (PhoneGap)",
				new ClickHandler() {
					public void onClick(ClickEvent event) {
						if (phoneGap.isPhoneGapInitialized()) {
							showInfo("UUID: " + phoneGap.getDevice().getUuid());
						} else {
							showError("phoneGap.isPhoneGapInitialized() = false");
						}

					}
				});

		vibratePhoneGapButton = new MyButton("vribrate (PhoneGap)",
				new ClickHandler() {
					public void onClick(ClickEvent event) {
						if (phoneGap.isPhoneGapInitialized()) {
							phoneGap.getNotification().vibrate(750 /* ms */);
						} else {
							showError("phoneGap.isPhoneGapInitialized() = false");
						}

					}
				});
		uuidPhoneGapButton.setEnabled(false);
		vibratePhoneGapButton.setEnabled(false);

		RootPanel.get().add(module1Button);
		RootPanel.get().add(uuidPhoneGapButton);
		RootPanel.get().add(vibratePhoneGapButton);

	}

	private void showInfo(String msg) {
		GWT.log("INFO: " + msg);
		Window.alert(msg);
	}

	private void showDebug(String msg) {
		GWT.log("DEBUG: " + msg);
		if (false) {
			Window.alert("DEBUG: " + msg);
		}
	}

	private void showError(String msg) {
		GWT.log("ERROR: " + msg);
		Window.alert("ERROR: " + msg);
	}

}
