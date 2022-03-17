package alf.api.archives;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class Document {

	private String documentid;
	private String foldername = null;
	private String folderpath = null;
	private String documentname = null;
	private Date createdate = null;
	private String des = null;

	private List<String> pathdoc = null;

	public Document(String documentid, String foldername, String folderpath, String documentname, Date createdate,
			String des) {

		this.documentid = documentid;
		this.foldername = foldername;
		this.folderpath = folderpath;
		this.documentname = documentname;
		this.createdate = createdate;
		this.des = des;
		this.pathdoc = new ArrayList<String>();

	}

	public Document() {
		this.pathdoc = new ArrayList<String>();
	}

	public String getDocumentid() {
		return documentid;
	}

	@XmlElement
	public void setDocumentid(String documentid) {
		this.documentid = documentid;
	}

	public String getFoldername() {
		return foldername;
	}

	@XmlElement
	public void setFoldername(String foldername) {
		this.foldername = foldername;
	}

	public String getFolderpath() {
		return folderpath;
	}

	@XmlElement
	public void setFolderpath(String folderpath) {
		this.folderpath = folderpath;
	}

	public String getDocumentname() {
		return documentname;
	}

	@XmlElement
	public void setDocumentname(String documentname) {
		this.documentname = documentname;
	}

	public Date getCreatedate() {
		return createdate;
	}

	@XmlElement
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getDes() {
		return des;
	}

	@XmlElement
	public void setDes(String des) {
		this.des = des;
	}

	public List<String> getPathdoc() {
		if (null == pathdoc)
			pathdoc = new ArrayList<String>();
		return pathdoc;
	}

	@XmlElement
	public void setPathdoc(List<String> pathdoc) {
		this.pathdoc = pathdoc;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.documentid == null) {
			return false;
		}

		if (obj instanceof Document && obj.getClass().equals(getClass())) {
			return this.documentid.equals(((Document) obj).documentid);
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 43 * hash + (documentid == null ? 0 : documentid.hashCode());
		return hash;
	}

	@Override
	public String toString() {
		return documentid + " " + documentname;
	}

}
