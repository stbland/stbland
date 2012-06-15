package org.stbland.musicgwt.client.ioc;

import org.stbland.musicgwt.client.views.FolderView;
import org.stbland.musicgwt.client.views.impl.FolderViewImpl;
import org.stbland.musicgwt.shared.CustomRequestTransport;
import org.stbland.musicgwt.shared.FolderRequest;
import org.stbland.musicgwt.shared.MusicRequest;
import org.stbland.musicgwt.shared.MusicRequestFactory;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.web.bindery.requestfactory.shared.RequestTransport;

public class GxtUiModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		// bind(RequestTransport.class).to(CustomRequestTransport.class).in(	Singleton.class);

		// View implementation binding - if we build a mobile explorer, this
		// would
		// be broken out into another module so it could be rebound
		bind(FolderView.class).to(FolderViewImpl.class).in(Singleton.class);
	}

	@Provides
	@Singleton
	public MusicRequestFactory createMusicRequestFactory(EventBus eventBus /*,
			RequestTransport transport*/) {

		MusicRequestFactory requestFactory = GWT
				.create(MusicRequestFactory.class);

		requestFactory.initialize(eventBus);
		// requestFactory.initialize(eventBus, transport);

		return requestFactory;

	}

	@Provides
	public MusicRequest createMusicRequest(MusicRequestFactory requestFactory) {

		return requestFactory.music();
	}

	@Provides
	public FolderRequest createFolderRequest(MusicRequestFactory requestFactory) {

		return requestFactory.folder();
	}

}
