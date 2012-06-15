package org.stbland.musicgwt.shared;

import java.util.List;

import org.stbland.musicgwt.server.data.Folder;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Folder.class)
public interface FolderRequest extends RequestContext {
	Request<FolderProxy> getRootFolder();

	InstanceRequest<FolderProxy, List<MusicProxy>> getChildren();

	InstanceRequest<FolderProxy, List<FolderProxy>> getSubFolders();
}
