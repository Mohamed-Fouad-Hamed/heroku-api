package alf.api.web.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "base_item_type", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
@SQLDelete(sql = "UPDATE Base_Item_Type " + "SET deleted = true " + "WHERE id = ?")
@Where(clause = "deleted=false")
public class BaseItemType extends BaseEntity<String> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false, length = 70)
	private String name = null;

	@Column(name = "shorthand", nullable = false, length = 20)
	private String shorthand = null;

	@Column(name = "has_info", nullable = false)
	private boolean has_info = false;

	@Column(name = "has_financial", nullable = false)
	private boolean has_financial = false;

	@Column(name = "has_document", nullable = false)
	private boolean has_document = false;

	@Column(name = "has_production", nullable = false)
	private boolean has_production = false;

	@Column(name = "has_device", nullable = false)
	private boolean has_device = false;

	@Column(name = "has_pointsale", nullable = false)
	private boolean has_pointsale = false;

	public boolean isHas_device() {
		return has_device;
	}

	public void setHas_device(boolean has_device) {
		this.has_device = has_device;
	}

	public boolean isHas_pointsale() {
		return has_pointsale;
	}

	public void setHas_pointsale(boolean has_pointsale) {
		this.has_pointsale = has_pointsale;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type", orphanRemoval = true)
	private List<BaseItem> items = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShorthand() {
		return shorthand;
	}

	public void setShorthand(String shorthand) {
		this.shorthand = shorthand;
	}

	public boolean isHas_info() {
		return has_info;
	}

	public void setHas_info(boolean has_info) {
		this.has_info = has_info;
	}

	public boolean isHas_financial() {
		return has_financial;
	}

	public void setHas_financial(boolean has_financial) {
		this.has_financial = has_financial;
	}

	public boolean isHas_document() {
		return has_document;
	}

	public void setHas_document(boolean has_document) {
		this.has_document = has_document;
	}

	public boolean isHas_production() {
		return has_production;
	}

	public void setHas_production(boolean has_production) {
		this.has_production = has_production;
	}

	public List<BaseItem> getItems() {
		return items;
	}

	public void setItems(List<BaseItem> items) {
		this.items = items;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		return name != null && name.equals(((BaseItemType) obj).name);
	}

	@Override
	public int hashCode() {
		return 2061;
	}

	@Override
	public String toString() {
		return "BaseItem [name=" + name + "]";
	}

}
