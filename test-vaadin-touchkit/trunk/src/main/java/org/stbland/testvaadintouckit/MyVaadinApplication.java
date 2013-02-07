package org.stbland.testvaadintouckit;

import com.vaadin.addon.touchkit.ui.TouchKitApplication;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends TouchKitApplication
{
    
    @Override
    public void onBrowserDetailsReady() {
        Button button = new Button("Who I am");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                event.getButton().getWindow().addComponent(new Label("STB Land"));
            }
        });
        getMainWindow().addComponent(button);
    }

    
}
