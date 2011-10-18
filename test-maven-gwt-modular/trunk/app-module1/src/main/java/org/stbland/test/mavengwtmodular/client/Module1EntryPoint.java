package org.stbland.test.mavengwtmodular.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class Module1EntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {

		Button button = new Button("Module 1 test", new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.alert("Module 1 OK");
			}
		});

		RootPanel.get().add(button);
	}

}
