package org.stbland.test.mavengwtmodular.client;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;

public class MyButton extends Button {

	public MyButton(String html) {
		super(html);
	}

	public MyButton(String html, ClickHandler handler) {
		super(html, handler);
	}

}
