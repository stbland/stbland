package org.stbland.testvaadintouchkit;

import org.stbland.testvaadintouchkit.server.view.impl.MobileTestWindow;
import org.stbland.testvaadintouchkit.server.view.impl.SmartphoneMainView;
import org.stbland.testvaadintouchkit.server.view.impl.TabletMainView;

import com.vaadin.addon.touchkit.ui.TouchKitApplication;
import com.vaadin.terminal.gwt.server.WebBrowser;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class TestVaadinTouchkitApplication extends TouchKitApplication {
	

    @Override
    public void init() {
        setMainWindow(new MobileTestWindow());
    }

	@Override
	public void onBrowserDetailsReady() {
		WebBrowser browser = getBrowser();
		if (!browser.isTouchDevice()) {
			getMainWindow()
					.showNotification(
							"You appear to be running on a desktop software or other non touch device. We'll show you the tablet (or smartphone view if small screen size) for debug purposess.");
		}

		if ( true  || isSmallScreenDevice()) {
			getMainWindow().setContent(new SmartphoneMainView());
		} else {
//			getMainWindow().setContent(new TabletMainView());
		}

	}

	public boolean isSmallScreenDevice() {
		float viewPortWidth = getMainWindow().getWidth();
		return viewPortWidth < 600;
	}

}
