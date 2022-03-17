package alf.api.web.models;

import java.io.Serializable;
import java.util.Arrays;

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
@Table(name = "u_images")
public class U_Image implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8719766057075799940L;

	private int id;
	private int unitid;
	private byte[] uimage;
	private P_Unit mUnit;

	public U_Image(int id, int unitid, byte[] uimage) {
		this.id = id;
		this.unitid = unitid;
		this.uimage = uimage;
	}

	public U_Image() {
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

	@Column(name = "uimage", nullable = true)
	public byte[] getUimage() {
		return uimage;
	}

	public void setUimage(byte[] uimage) {
		this.uimage = uimage;
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
		result = prime * result + Arrays.hashCode(uimage);
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
		U_Image other = (U_Image) obj;
		if (id != other.id)
			return false;
		if (!Arrays.equals(uimage, other.uimage))
			return false;
		if (unitid != other.unitid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "U_Image [id=" + id + ", unitid=" + unitid + ", uimage=" + Arrays.toString(uimage) + "]";
	}

}
