package org.stbland.musicgwt.client.views.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.stbland.musicgwt.client.views.FolderView;
import org.stbland.musicgwt.shared.FolderProxy;
import org.stbland.musicgwt.shared.FolderRequest;
import org.stbland.musicgwt.shared.MusicProxy;
import org.stbland.musicgwt.shared.MusicRequest;
import org.stbland.musicgwt.shared.MusicRequestFactory;
import org.stbland.musicgwt.shared.NamedProxy;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.data.shared.loader.DataProxy;
import com.sencha.gxt.data.shared.loader.TreeLoader;
import com.sencha.gxt.widget.core.client.tree.Tree;

public class FolderViewImpl implements FolderView {

	// @Inject
	//private EventBus eventBus;
	
	@Inject
	private Provider<MusicRequest> musicRequestProvider;
	
	@Inject
	private Provider<FolderRequest> folderRequestProvider;	

	private HorizontalPanel panel;

	interface NamedProxyProperties extends PropertyAccess<NamedProxy> {
		ModelKeyProvider<NamedProxy> stableId();

		ValueProvider<NamedProxy, String> name();
	}

	private NamedProxyProperties properties = GWT
			.create(NamedProxyProperties.class);

	// private MusicRequestFactory requestFactory;

	// This is a custom data proxy, designed to serve as the interface between
	// the
	// client's needs and the server's capabilities. If the server and client
	// were
	// in complete agreement, it would be possible to write this as a
	// RequestFactoryProxy impl
	private final DataProxy<NamedProxy, List<NamedProxy>> proxy = new DataProxy<NamedProxy, List<NamedProxy>>() {
		@Override
		public void load(final NamedProxy loadConfig,
				final Callback<List<NamedProxy>, Throwable> callback) {

			Receiver<List<? extends NamedProxy>> receiver = new Receiver<List<? extends NamedProxy>>() {
				@Override
				public void onSuccess(List<? extends NamedProxy> response) {
					if (response.size() == 0) {
						// assuming that only folders OR music will be returned.
						return;
					}
					callback.onSuccess(new ArrayList<NamedProxy>(response));
				}
			};

			/*
			if (requestFactory == null) {
				GWT.log("requestFactory = null");
				return;
			}
			*/

			if (loadConfig == null) {

				final Receiver<FolderProxy> folderReceiver = new Receiver<FolderProxy>() {
					@Override
					public void onSuccess(FolderProxy response) {
						callback.onSuccess(Collections
								.<NamedProxy> singletonList(response));
					}
				};
				
				/*
				if (requestFactory.folder() == null) {
					GWT.log("requestFactory.folder = null");
					return;
				}

				if (requestFactory.folder().getRootFolder() == null) {
					GWT.log("requestFactory.folder.RootFolder = null");
					return;
				}
				*/
				
				FolderRequest folderRequest = folderRequestProvider.get();
				folderRequest.getRootFolder().fire(folderReceiver);

				// requestFactory.folder().getRootFolder().fire(folderReceiver);
			} else {
				// FolderRequest req = requestFactory.folder();
				FolderRequest folderRequest = folderRequestProvider.get();
				
				folderRequest.getChildren().using((FolderProxy) loadConfig).to(receiver);
				folderRequest.getSubFolders().using((FolderProxy) loadConfig)
						.to(receiver);
				folderRequest.fire();
			}
		}
	};

	private TreeStore<NamedProxy> treeStore = new TreeStore<NamedProxy>(
			properties.stableId());

	private final TreeLoader<NamedProxy> loader = new TreeLoader<NamedProxy>(
			proxy) {
		public boolean hasChildren(NamedProxy parent) {
			return parent instanceof FolderProxy;
		}
	};


	
	
	public FolderViewImpl() {
		super();

		// requestFactory = GWT.create(MusicRequestFactory.class);
		// requestFactory.initialize(eventBus);

		panel = new HorizontalPanel();
		panel.setSpacing(10);

		Label label = new Label();
		label.setText("Folder view");
		panel.add(label);

		Tree<NamedProxy, String> tree = new Tree<NamedProxy, String>(treeStore,
				properties.name());

		panel.add(tree);
		panel.setCellWidth(tree, "260px");

		tree.getSelectionModel().addSelectionHandler(
				new SelectionHandler<NamedProxy>() {
					@Override
					public void onSelection(SelectionEvent<NamedProxy> event) {
						if (event.getSelectedItem() instanceof MusicProxy) {
							// When a Music object is selected, edit it
							// TODO disallow editing in cases where the last
							// has not been saved?

							MusicProxy music = (MusicProxy) event
									.getSelectedItem();

						} else {

						}
					}
				});

		if (true) {

			tree.setLoader(loader);

		}
		// initWidget(panel);
	}

	@Override
	public Widget asWidget() {
		return panel;
	}
}
