package org.stbland.musicgwt.server.data;

import java.util.List;

public interface FolderDao {

	public List<Folder> findAllFolders();

	public Folder findFolder(Integer id);

	public Folder getRootFolder();

	public Folder persist(Folder folder);

	public void remove(Folder folder);

}
