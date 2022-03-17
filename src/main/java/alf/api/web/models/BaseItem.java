package alf.api.web.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "base_item")
@SQLDelete(sql = "UPDATE Base_Item " + "SET deleted = true " + "WHERE id = ?")
@Where(clause = "deleted=false")
public class BaseItem extends BaseEntity<String> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", nullable = false, length = 70)
	private String name = null;

	@Column(name = "image", columnDefinition = "text", length = 65535)
	private String image;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	@JsonIgnore
	private BaseItemType type;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = true)
	private BaseItemInfo baseItemInfo;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = true)
	private BaseItemFinancial baseItemFinancial;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = true)
	private BaseItemDocument baseItemDocument;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = true)
	private BaseItemProduction baseItemProduction;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = true)
	private BaseItemDevice baseItemDevice;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "item", orphanRemoval = true)
	private BaseItemPointSale baseItemPointSale;

	public BaseItemDevice getBaseItemDevice() {
		return baseItemDevice;
	}

	public void setBaseItemDevice(BaseItemDevice baseItemDevice) {
		this.baseItemDevice = baseItemDevice;
	}

	public BaseItemPointSale getBaseItemPointSale() {
		return baseItemPointSale;
	}

	public void setBaseItemPointSale(BaseItemPointSale baseItemPointSale) {
		this.baseItemPointSale = baseItemPointSale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BaseItemType getType() {
		return type;
	}

	public void setType(BaseItemType type) {
		this.type = type;
	}

	public BaseItemInfo getBaseItemInfo() {
		return baseItemInfo;
	}

	public void setBaseItemInfo(BaseItemInfo baseItemInfo) {
		this.baseItemInfo = baseItemInfo;
	}

	public BaseItemFinancial getBaseItemFinancial() {
		return baseItemFinancial;
	}

	public void setBaseItemFinancial(BaseItemFinancial baseItemFinancial) {
		this.baseItemFinancial = baseItemFinancial;
	}

	public BaseItemDocument getBaseItemDocument() {
		return baseItemDocument;
	}

	public void setBaseItemDocument(BaseItemDocument baseItemDocument) {
		this.baseItemDocument = baseItemDocument;
	}

	public BaseItemProduction getBaseItemProduction() {
		return baseItemProduction;
	}

	public void setBaseItemProduction(BaseItemProduction baseItemProduction) {
		this.baseItemProduction = baseItemProduction;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		return name != null && name.equals(((BaseItem) obj).name);
	}

	@Override
	public int hashCode() {
		return 2071;
	}

	@Override
	public String toString() {
		return "BaseItem [name=" + name + ", type=" + type + "]";
	}

}
