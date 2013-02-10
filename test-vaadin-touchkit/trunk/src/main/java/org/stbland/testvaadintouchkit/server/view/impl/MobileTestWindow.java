package org.stbland.testvaadintouchkit.server.view.impl;

import com.vaadin.addon.touchkit.ui.TouchKitWindow;

@SuppressWarnings("serial")
public class MobileTestWindow extends TouchKitWindow {

	public MobileTestWindow() {
		setCaption("Test Vaadin Touchkit");
		setImmediate(true);
	}
}