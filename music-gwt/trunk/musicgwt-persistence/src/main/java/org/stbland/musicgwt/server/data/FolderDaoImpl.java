package org.stbland.musicgwt.server.data;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.stbland.musicgwt.dao.impl.AbstractJpaDao;

@Repository
public class FolderDaoImpl extends AbstractJpaDao<Folder, Integer> implements
		FolderDao {

	public FolderDaoImpl() {
		super();
		setClazz(Folder.class);
	}

	public List<Folder> findAllFolders() {
		return findAll();
	}

	public Folder findFolder(Integer id) {
		return findOne(id);
	}

	public Folder getRootFolder() {
		final Query query = getEntityManager().createQuery(
				"from " + getEntityName() + " f where f.parentFolder is null");
		return (Folder) query.getSingleResult();
	}

	public Folder persist(Folder folder) {
		return save(folder);
	}

	public void remove(Folder folder) {
		remove(folder);
	}

}
