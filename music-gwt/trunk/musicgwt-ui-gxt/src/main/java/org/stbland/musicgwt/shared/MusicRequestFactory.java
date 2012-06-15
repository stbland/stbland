package org.stbland.musicgwt.shared;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface MusicRequestFactory extends RequestFactory {
	MusicRequest music();

	FolderRequest folder();

}
