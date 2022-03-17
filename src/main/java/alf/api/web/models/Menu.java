package alf.api.web.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "menus")
public class Menu {

	private long mnuid;
	private String headertext;
	private String c_object;
	private int mtype;
	private long containermenu;
	private int level;
	private boolean isparent;
	private boolean visible;
	private String menuicon;
	private String shortcut;
	private boolean ischild;
	private Set<MenuPanel> panels = new HashSet<MenuPanel>();
	private Set<MenuPrivileges> privileges = new HashSet<MenuPrivileges>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mnuid", unique = true, nullable = false)
	public long getMnuid() {
		return mnuid;
	}

	public void setMnuid(long mnuid) {
		this.mnuid = mnuid;
	}

	@Column(name = "headertext", length = 70)
	public String getHeadertext() {
		return headertext;
	}

	public void setHeadertext(String headertext) {
		this.headertext = headertext;
	}

	@Column(name = "c_object", length = 100)
	public String getC_object() {
		return c_object;
	}

	public void setC_object(String c_object) {
		this.c_object = c_object;
	}

	@Column(name = "mtype")
	public int getMtype() {
		return mtype;
	}

	public void setMtype(int mtype) {
		this.mtype = mtype;
	}

	@Column(name = "containermenu")
	public long getContainermenu() {
		return containermenu;
	}

	public void setContainermenu(long containermenu) {
		this.containermenu = containermenu;
	}

	@Column(name = "level")
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Column(name = "isparent")
	public boolean isIsparent() {
		return isparent;
	}

	public void setIsparent(boolean isparent) {
		this.isparent = isparent;
	}

	@Column(name = "visible")
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Column(name = "menuicon", columnDefinition = "text", length = 65535)
	public String getMenuicon() {
		return menuicon;
	}

	public void setMenuicon(String menuicon) {
		this.menuicon = menuicon;
	}

	@Column(name = "shortcut", length = 45)
	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	@Column(name = "ischild")
	public boolean isIschild() {
		return ischild;
	}

	public void setIschild(boolean ischild) {
		this.ischild = ischild;
	}

	@OneToMany(mappedBy = "menu", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("id")
	public Set<MenuPanel> getPanels() {
		return panels;
	}

	public void setPanels(Set<MenuPanel> panels) {
		this.panels = panels;
	}

	@OneToMany(mappedBy = "menu", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy("id")
	public Set<MenuPrivileges> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<MenuPrivileges> privileges) {
		this.privileges = privileges;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_object == null) ? 0 : c_object.hashCode());
		result = prime * result + ((headertext == null) ? 0 : headertext.hashCode());
		result = prime * result + (ischild ? 1231 : 1237);
		result = prime * result + (isparent ? 1231 : 1237);
		result = prime * result + level;
		result = prime * result + ((menuicon == null) ? 0 : menuicon.hashCode());
		result = prime * result + mtype;
		result = prime * result + ((shortcut == null) ? 0 : shortcut.hashCode());
		result = prime * result + (visible ? 1231 : 1237);
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
		Menu other = (Menu) obj;
		if (c_object == null) {
			if (other.c_object != null)
				return false;
		} else if (!c_object.equals(other.c_object))
			return false;
		if (containermenu != other.containermenu)
			return false;
		if (headertext == null) {
			if (other.headertext != null)
				return false;
		} else if (!headertext.equals(other.headertext))
			return false;
		if (ischild != other.ischild)
			return false;
		if (isparent != other.isparent)
			return false;
		if (level != other.level)
			return false;
		if (menuicon == null) {
			if (other.menuicon != null)
				return false;
		} else if (!menuicon.equals(other.menuicon))
			return false;
		if (mnuid != other.mnuid)
			return false;
		if (mtype != other.mtype)
			return false;
		if (shortcut == null) {
			if (other.shortcut != null)
				return false;
		} else if (!shortcut.equals(other.shortcut))
			return false;
		if (visible != other.visible)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [mnuid=" + mnuid + ", headertext=" + headertext + ", c_object=" + c_object + ", mtype=" + mtype
				+ ", containermenu=" + containermenu + ", level=" + level + ", isparent=" + isparent + ", visible="
				+ visible + ", menuicon=" + menuicon + ", shortcut=" + shortcut + ", ischild=" + ischild + "]";
	}

}
