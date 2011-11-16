package org.stbland.test.mavengwtmodular.module3.client.views;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.IsWidget;
import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;

public interface ViewGwt extends IsWidget {
	public HasText getHeader();

	public HasText getBackButtonText();

	public HasTapHandlers getBackButton();

	public HasText getMainButtonText();

	public HasTapHandlers getMainButton();

	public void setTitle(String title);

	public void setBackButtonText(String text);

}
