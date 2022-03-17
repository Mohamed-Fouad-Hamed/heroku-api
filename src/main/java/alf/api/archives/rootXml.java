package alf.api.archives;

import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class rootXml {

	private String drive = null;
	private String rootName = null;
	private List<Folder> directories = null;

	public rootXml() {
		directories = new ArrayList<Folder>();
	}

	public String getDrive() {
		return drive;
	}

	@XmlElement
	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String getRootName() {
		return rootName;
	}

	@XmlElement
	public void setRootName(String rootName) {
		this.rootName = rootName;
	}

	public List<Folder> getDirectories() {
		return directories;
	}

	@XmlElement
	public void setDirectories(List<Folder> directories) {
		this.directories = directories;
	}

	// public void addFolder(Folder folder) {directories.add(folder);}

}
