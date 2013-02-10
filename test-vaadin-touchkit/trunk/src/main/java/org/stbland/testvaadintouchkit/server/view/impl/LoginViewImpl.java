package org.stbland.testvaadintouchkit.server.view.impl;

import com.vaadin.addon.touchkit.ui.EmailField;
import com.vaadin.addon.touchkit.ui.NavigationBar;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LoginViewImpl extends NavigationView {

	 private VerticalLayout content = new VerticalLayout();
	 private NavigationBar navigationBar = new NavigationBar();
	 private FormLayout fields = new FormLayout();
	 
	private EmailField loginField = new EmailField();
	private PasswordField passwordField = new PasswordField();
	private boolean smartphone;

	public LoginViewImpl(boolean smartphone) {
		// setCaption("Identification");
		
		navigationBar.setWidth("100%");
        navigationBar.setCaption("Identification");        
        navigationBar.setRightComponent(new Button("S'identifier"));

        content.setSizeFull();
        content.addComponent(navigationBar);

        
        fields.setMargin(false, true, false, true);
        fields.setSpacing(false);

        loginField.setWidth("100%");
        fields.addComponent(loginField);

        
        passwordField.setWidth("100%");
        fields.addComponent(passwordField);

        content.addComponent(fields);

        setContent(content);

        // Popover
      //  setModal(true);
//        setClosable(false);
        if (smartphone) {
            setSizeFull();
        } else {
            setHeight("100%");
    //        center();
        }
        this.smartphone = smartphone;

	}


	
	 @Override
	    public void attach() {
	        super.attach();
	        if (!smartphone) {
	            if (getParent().getWidth() > 800) {
	                setWidth("80%");
	            } else {
	                setWidth("100%");
	            }
	        }
	    }

}
