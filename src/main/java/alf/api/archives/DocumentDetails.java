package alf.api.archives;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class DocumentDetails {

	private Long ddid = null;
	private Long documentid = null;
	private String des = null;
	private String docimage = null;

	public Long getDdid() {
		return ddid;
	}

	@XmlElement
	public void setDdid(Long ddid) {
		this.ddid = ddid;
	}

	public Long getDocumentid() {
		return documentid;
	}

	@XmlElement
	public void setDocumentid(Long documentid) {
		this.documentid = documentid;
	}

	public String getDes() {
		return des;
	}

	@XmlElement
	public void setDes(String des) {
		this.des = des;
	}

	public String getDocimage() {
		return docimage;
	}

	@XmlElement
	public void setDocimage(String docimage) {
		this.docimage = docimage;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.ddid == 0) {
			return false;
		}

		if (obj instanceof DocumentDetails && obj.getClass().equals(getClass())) {
			return this.ddid.equals(((DocumentDetails) obj).ddid);
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 43 * hash + (ddid == null ? 0 : ddid.hashCode());
		return hash;
	}

	@Override
	public DocumentDetails clone() throws CloneNotSupportedException {
		return (DocumentDetails) super.clone();
	}

	@Override
	public String toString() {
		return ddid + " " + des;
	}

}
