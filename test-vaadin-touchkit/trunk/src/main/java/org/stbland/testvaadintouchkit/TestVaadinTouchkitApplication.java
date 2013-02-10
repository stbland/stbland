package org.stbland.testvaadintouchkit;

import com.vaadin.addon.touchkit.ui.TouchKitApplication;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class TestVaadinTouchkitApplication extends TouchKitApplication
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
