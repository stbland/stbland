package org.stbland.musicgwt.shared;

import org.stbland.musicgwt.server.data.Music;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(Music.class)
public interface MusicProxy extends EntityProxy, NamedProxy {
	String getName();

	void setName(String name);

	String getAuthor();

	void setAuthor(String author);

	String getGenre();

	void setGenre(String genre);

	@Override
	public EntityProxyId<MusicProxy> stableId();
}
