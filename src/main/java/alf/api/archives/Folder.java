package alf.api.archives;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class Folder {

	private int folderid;
	private String displayname = null;
	private String foldername = null;
	private int parentid = 0;
	private String fullpath = null;
	private String notes = null;

	public Folder() {
		this.folderid = 0;
		this.displayname = "";
		this.foldername = "";
		this.parentid = 0;
		this.fullpath = "";
		this.notes = "";
	}

	public Folder(int folderid, String displayname, String foldername, int parentid, String fullname, String notes) {
		this.folderid = folderid;
		this.displayname = displayname;
		this.foldername = foldername;
		this.parentid = parentid;
		this.fullpath = fullname;
		this.notes = notes;
	}

	public int getFolderid() {
		return folderid;
	}

	@XmlElement
	public void setFolderid(int folderid) {
		this.folderid = folderid;
	}

	public String getDisplayname() {
		return displayname;
	}

	@XmlElement
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getFoldername() {
		return foldername;
	}

	@XmlElement
	public void setFoldername(String foldername) {
		this.foldername = foldername;
	}

	public int getParentid() {
		return parentid;
	}

	@XmlElement
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	public String getFullpath() {
		return fullpath;
	}

	@XmlElement
	public void setFullpath(String fullpath) {
		this.fullpath = fullpath;
	}

	public String getNotes() {
		return notes;
	}

	@XmlElement
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.folderid == 0) {
			return false;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 43 * hash + (folderid == 0 ? 0 : folderid);
		return hash;
	}

	@Override
	public String toString() {
		return folderid + " " + foldername;
	}

}
