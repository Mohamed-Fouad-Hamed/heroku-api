package alf.api.web.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "menupanels")
public class MenuPanel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id = 0;
	private String name = "";
	private int ptype = 0;
	private String ptext = "";
	private String des = "";
	@JsonIgnore
	private Menu menu;
	private Set<PanelColumn> columns = new HashSet<PanelColumn>();

	public MenuPanel(long id, String name, int ptype, String ptext, String des) {
		super();
		this.id = id;
		this.ptype = ptype;
		this.ptext = ptext;
		this.des = des;
	}

	public MenuPanel() {
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

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "mptypeid", nullable = false)
	public int getPtype() {
		return ptype;
	}

	public void setPtype(int ptype) {
		this.ptype = ptype;
	}

	@Column(name = "ptext", nullable = false, length = 45)
	public String getPtext() {
		return ptext;
	}

	public void setPtext(String ptext) {
		this.ptext = ptext;
	}

	@Column(name = "des", nullable = false, length = 45)
	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@OneToMany(mappedBy = "menuPanel", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<PanelColumn> getColumns() {
		return columns;
	}

	public void setColumns(Set<PanelColumn> columns) {
		this.columns = columns;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id")
	@JsonIgnore
	public Menu getmenu() {
		return menu;
	}

	public void setmenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ptext == null) ? 0 : ptext.hashCode());
		result = prime * result + ptype;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuPanel other = (MenuPanel) obj;
		if (id != other.id)
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ptext == null) {
			if (other.ptext != null)
				return false;
		} else if (!ptext.equals(other.ptext))
			return false;
		if (ptype != other.ptype)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MenuPanel [id=" + id + ", name=" + name + ",  ptype=" + ptype + ", ptext=" + ptext
				+ "]";
	}

}
