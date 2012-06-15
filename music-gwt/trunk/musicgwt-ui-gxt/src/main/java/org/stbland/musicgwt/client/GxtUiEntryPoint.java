package org.stbland.musicgwt.client;

import org.stbland.musicgwt.client.app.GxtUiApp;
import org.stbland.musicgwt.client.ioc.GxtUiGinjector;
import org.stbland.musicgwt.client.views.FolderView;
import org.stbland.musicgwt.client.views.impl.FolderViewImpl;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.RootPanel;

public class GxtUiEntryPoint implements EntryPoint {

	private final GxtUiGinjector injector = GWT.create(GxtUiGinjector.class);

	@Override
	public void onModuleLoad() {
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				
				GxtUiApp app = injector.getApp();
		        app.run();		       		

				onReady();
			}

		});
	}

	private native void onReady() /*-{
									if (typeof $wnd.GxtReady != 'undefined') {
									$wnd.GxtReady();
									}
									}-*/;

}
