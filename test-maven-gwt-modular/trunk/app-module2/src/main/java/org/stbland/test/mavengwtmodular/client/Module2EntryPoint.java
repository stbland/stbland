package org.stbland.test.mavengwtmodular.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class Module2EntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {

		Button button = new MyButton("Button Module 1", new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.alert("Module 2 OK");
			}
		});

		RootPanel.get().add(button);
	}

}
