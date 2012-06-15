package org.stbland.musicgwt.server.data;

import org.springframework.stereotype.Repository;
import org.stbland.musicgwt.dao.impl.AbstractJpaDao;

@Repository
public class MusicDaoImpl extends AbstractJpaDao<Music, Integer> implements
		MusicDao {

	public MusicDaoImpl() {
		super();
		setClazz(Music.class);
	}

	public Music findMusic(Integer id) {

		return findOne(id);
	}

	public Music persist(Music music) {
		return save(music);
	}

	public void remove(Music music) {
		delete(music);

	}

}
