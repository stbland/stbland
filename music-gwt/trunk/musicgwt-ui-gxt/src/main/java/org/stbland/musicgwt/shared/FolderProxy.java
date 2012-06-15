package org.stbland.musicgwt.shared;

import org.stbland.musicgwt.server.data.Folder;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(Folder.class)
public interface FolderProxy extends EntityProxy, NamedProxy {
	String getName();

	void setName(String name);

	@Override
	public EntityProxyId<FolderProxy> stableId();
}
