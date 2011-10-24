package org.stbland.test.mavengwtmodular.module4.client.views;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;

public interface ViewGwt  extends IsWidget{
	public HasText getHeader();
	
	public HasText getBackButtonText();
	
	public HasClickHandlers getBackButton();
	
	public HasText getMainButtonText();
	
	public HasClickHandlers getMainButton();
	

}
