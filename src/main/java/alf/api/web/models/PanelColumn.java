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
@Table(name = "panelcolumns")
public class PanelColumn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id = 0;
	// private int pid = 0;
	private String name = "";
	private String text = "";
	private int cid = 0;
	private String mdisplay = "";
	private String mvalue = "";
	private String mselector = "";
	private String mcols = "";
	private int ctype = 0;
	private boolean visible = false;
	private boolean lock = false;
	private Set<ColumnEvent> events = new HashSet<ColumnEvent>();
	@JsonIgnore
	private MenuPanel menuPanel;

	public PanelColumn(long id, String name, String text, int pid, int cid, String mdisplay, String mvalue,
			String mselector, String mcols, int ctype, boolean visible, boolean lock) {
		super();
		this.id = id;
		// this.pid = pid;
		this.name = name;
		this.text = text;
		this.cid = cid;
		this.mdisplay = mdisplay;
		this.mvalue = mvalue;
		this.mselector = mselector;
		this.mcols = mcols;
		this.ctype = ctype;
		this.visible = visible;
		this.lock = lock;
	}

	public PanelColumn() {
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

	@Column(name = "text", nullable = false, length = 45)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "cid", nullable = false)
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Column(name = "mdisplay", nullable = false, length = 45)
	public String getMdisplay() {
		return mdisplay;
	}

	public void setMdisplay(String mdisplay) {
		this.mdisplay = mdisplay;
	}

	@Column(name = "mvalue", nullable = false, length = 45)
	public String getMvalue() {
		return mvalue;
	}

	public void setMvalue(String mvalue) {
		this.mvalue = mvalue;
	}

	@Column(name = "mselector", nullable = false, length = 45)
	public String getMselector() {
		return mselector;
	}

	public void setMselector(String mselector) {
		this.mselector = mselector;
	}

	@Column(name = "mcols", nullable = false, length = 45)
	public String getMcols() {
		return mcols;
	}

	public void setMcols(String mcols) {
		this.mcols = mcols;
	}

	@Column(name = "ctypeid", nullable = false)
	public int getCtype() {
		return ctype;
	}

	public void setCtype(int ctype) {
		this.ctype = ctype;
	}

	@Column(name = "isvisible", nullable = false)
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Column(name = "islock", nullable = false)
	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	@OneToMany(mappedBy = "panelColumn", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<ColumnEvent> getEvents() {
		return this.events;
	}

	public void setEvents(Set<ColumnEvent> events) {
		this.events = events;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "panel_id")
	@JsonIgnore
	public MenuPanel getmenuPanel() {
		return menuPanel;
	}

	public void setmenuPanel(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
		result = prime * result + ctype;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (lock ? 1231 : 1237);
		result = prime * result + ((mcols == null) ? 0 : mcols.hashCode());
		result = prime * result + ((mdisplay == null) ? 0 : mdisplay.hashCode());
		result = prime * result + ((mselector == null) ? 0 : mselector.hashCode());
		result = prime * result + ((mvalue == null) ? 0 : mvalue.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		PanelColumn other = (PanelColumn) obj;
		if (cid != other.cid)
			return false;
		if (ctype != other.ctype)
			return false;
		if (id != other.id)
			return false;
		if (lock != other.lock)
			return false;
		if (mcols == null) {
			if (other.mcols != null)
				return false;
		} else if (!mcols.equals(other.mcols))
			return false;
		if (mdisplay == null) {
			if (other.mdisplay != null)
				return false;
		} else if (!mdisplay.equals(other.mdisplay))
			return false;
		if (mselector == null) {
			if (other.mselector != null)
				return false;
		} else if (!mselector.equals(other.mselector))
			return false;
		if (mvalue == null) {
			if (other.mvalue != null)
				return false;
		} else if (!mvalue.equals(other.mvalue))
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
		if (visible != other.visible)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PanelColumn [id=" + id + ", name=" + name + ", text=" + text + ", cid=" + cid
				+ ", mdisplay=" + mdisplay + ", mvalue=" + mvalue + ", mselector=" + mselector + ", mcols=" + mcols
				+ ", ctype=" + ctype + ", visible=" + visible + ", lock=" + lock + "]";
	}

}
