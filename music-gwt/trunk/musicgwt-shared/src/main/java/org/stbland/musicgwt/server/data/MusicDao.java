package org.stbland.musicgwt.server.data;

public interface MusicDao {

	public Music findMusic(Integer id);

	public Music persist(Music music);

	public void remove(Music music);

}
