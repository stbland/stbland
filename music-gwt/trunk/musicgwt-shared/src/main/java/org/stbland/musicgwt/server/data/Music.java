package org.stbland.musicgwt.server.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
public class Music implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;

	@Version
	private Integer version;

	@Size(min = 1)
	private String name;

	@Size(min = 1)
	private String author;

	private String genre;

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getVersion() {
		return version;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
