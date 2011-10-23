package org.stbland.test.mavengwtmodular.module3.client.views;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.touch.simple.HasSimpleTouchHandler;

public interface ViewGwt  extends IsWidget{
	public HasText getHeader();
	
	public HasText getBackButtonText();
	
	public HasSimpleTouchHandler getBackButton();
	
	public HasText getMainButtonText();
	
	public HasSimpleTouchHandler getMainButton();
	

}
