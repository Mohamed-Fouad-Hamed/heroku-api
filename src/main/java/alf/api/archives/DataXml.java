package alf.api.archives;

import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class DataXml {
	private List<Document> documents = null;

	public DataXml() {
		documents = new ArrayList<Document>();
	}

	public void addDocument(Document document) {
		documents.add(document);
	}

	public List<Document> getDocuments() {
		return documents;
	}

	@XmlElement
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public int Idendtity() {
		int id = 1;
		id = (this.documents == null || this.documents.isEmpty()) ? id : this.documents.size() + 1;
		return id;
	}

}
