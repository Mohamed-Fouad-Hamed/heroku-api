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
@Table(name = "u_barcodes")
public class U_Barcode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 699738043884987245L;

	private int id;
	private int unitid;
	private String barcode;
	private P_Unit mUnit;

	public U_Barcode(int id, int unitid, String barcode) {
		this.id = id;
		this.unitid = unitid;
		this.barcode = barcode;
	}

	public U_Barcode() {
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
	@Column(name = "barcode", nullable = false)
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
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
		result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
		result = prime * result + id;
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
		U_Barcode other = (U_Barcode) obj;
		if (barcode == null) {
			if (other.barcode != null)
				return false;
		} else if (!barcode.equals(other.barcode))
			return false;
		if (id != other.id)
			return false;
		if (unitid != other.unitid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "U_Barcode [id=" + id + ", unitid=" + unitid + ", barcode=" + barcode + "]";
	}

}
