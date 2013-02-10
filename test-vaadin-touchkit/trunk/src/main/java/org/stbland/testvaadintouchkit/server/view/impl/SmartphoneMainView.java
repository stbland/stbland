package org.stbland.testvaadintouchkit.server.view.impl;

import org.stbland.testvaadintouchkit.server.view.MainView;

import com.vaadin.addon.touchkit.ui.NavigationManager;

@SuppressWarnings("serial")
public class SmartphoneMainView extends NavigationManager implements MainView {
	
	public SmartphoneMainView() {
        setWidth("100%"); // to support wider horizontal view
     //   addStyleName("phone");
        navigateTo(new LoginViewImpl(true));
        
    }

}