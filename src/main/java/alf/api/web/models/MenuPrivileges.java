package alf.api.web.models;

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
@Table(name = "menu_privileges")
public class MenuPrivileges {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id = 0;

	@Column(name = "base_item_id", nullable = false)
	private long baseItemId = 0;

	@Column(name = "name", nullable = true, length = 45)
	private String name = null;

	@Column(name = "text", nullable = true, length = 45)
	private String text = null;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "menu_id")
	@JsonIgnore
	private Menu menu;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBaseItemId() {
		return baseItemId;
	}

	public void setBaseItemId(long baseItemId) {
		this.baseItemId = baseItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (baseItemId ^ (baseItemId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		MenuPrivileges other = (MenuPrivileges) obj;
		if (baseItemId != other.baseItemId)
			return false;
		if (id != other.id)
			return false;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MenuPrivileges [id=" + id + ", baseItemId=" + baseItemId + ", name=" + name + ", text=" + text
				+ ", menu=" + menu + "]";
	}

}
