package alf.api.web.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "columnevents")
public class ColumnEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id = 0;
	// private int colid = 0;
	private String type = "";
	private String content = "";
	private PanelColumn panelColumn_Id;

	public ColumnEvent(int id, int colid, String type, String content) {
		super();
		this.id = id;
		// this.colid = colid;
		this.type = type;
		this.content = content;
	}

	public ColumnEvent() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "type", nullable = false, length = 45)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "content", nullable = false, length = 255)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "column_id")
	@JsonIgnore
	public PanelColumn getpanelColumn() {
		return panelColumn_Id;
	}

	public void setpanelColumn(PanelColumn panelColumn) {
		this.panelColumn_Id = panelColumn;
	}

	@Override
	public int hashCode() {

		return 2091;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColumnEvent other = (ColumnEvent) obj;

		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ColumnEvents [id=" + id + ", type=" + type + ", content=" + content + "]";
	}

}
