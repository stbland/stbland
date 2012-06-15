package org.stbland.musicgwt.server.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.Size;

@Entity
public class Folder implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Version
	private Integer version;

	@Size(min = 1)
	private String name;

	@ManyToOne(optional = true, fetch = FetchType.LAZY, cascade = {})
	private Folder parentFolder;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Folder> subFolders = new ArrayList<Folder>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Music> children = new ArrayList<Music>();

	public void addMusic(Music music) {
		children.add(music);
	}

	public void addSubFolder(Folder subFolder) {
		subFolder.parentFolder = this;
		subFolders.add(subFolder);
	}

	public List<Music> getChildren() {
		return children;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Folder> getSubFolders() {
		return subFolders;
	}

	public Integer getVersion() {
		return version;
	}

	public void setChildren(List<Music> children) {
		this.children = children;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubFolders(List<Folder> subFolders) {
		this.subFolders = subFolders;
	}

	public Folder getParentFolder() {
		return parentFolder;
	}

}
