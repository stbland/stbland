package org.stbland.musicgwt.client.app;

import org.stbland.musicgwt.client.views.FolderView;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;

public class GxtUiApp {

	@Inject
	private EventBus eventBus;

	@Inject
	private FolderView folderView;

	public void run() {
		// FolderView folderView = new FolderViewImpl();
		RootPanel.get().add(folderView);

	}

}
