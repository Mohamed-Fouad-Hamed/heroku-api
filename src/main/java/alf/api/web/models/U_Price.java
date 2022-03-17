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

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "u_prices")
public class U_Price implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3440915382535598319L;

	private int id;
	private int unitid;
	private int priceid;
	private float price;
	private P_Unit mUnit;

	public U_Price(int id, int unitid, int priceid, float price) {
		this.id = id;
		this.unitid = unitid;
		this.priceid = priceid;
		this.price = price;
	}

	public U_Price() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotBlank
	@Column(name = "unitid", nullable = false)
	public int getUnitid() {
		return unitid;
	}

	public void setUnitid(int unitid) {
		this.unitid = unitid;
	}

	@NotBlank
	@Column(name = "priceid", nullable = false)
	public int getPriceid() {
		return priceid;
	}

	public void setPriceid(int priceid) {
		this.priceid = priceid;
	}

	@NotBlank
	@Column(name = "price", nullable = false)
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "unitid", referencedColumnName = "id", insertable = false, updatable = false)
	public P_Unit getmUnit() {
		return mUnit;
	}

	public void setmUnit(P_Unit mUnit) {
		this.mUnit = mUnit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + priceid;
		result = prime * result + unitid;
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
		U_Price other = (U_Price) obj;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (priceid != other.priceid)
			return false;
		if (unitid != other.unitid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "U_Price [id=" + id + ", unitid=" + unitid + ", priceid=" + priceid + ", price=" + price + "]";
	}

}
