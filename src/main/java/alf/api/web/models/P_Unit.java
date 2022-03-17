package alf.api.web.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "p_units")
public class P_Unit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7886512509089123944L;

	private int id;
	private int productid;
	private boolean isbasic;
	private int childid;
	private float oper;
	private int parentid;
	private float costprice;
	private float tax;
	private float pricein;
	private float profitpercent;
	private float profitvalue;
	private float priceout;
	private List<U_Price> u_prices = new ArrayList<U_Price>();
	private List<U_Barcode> u_barcodes = new ArrayList<U_Barcode>();
	private List<U_Image> u_images = new ArrayList<U_Image>();
	private Product mProduct;

	public P_Unit(int id, int productid, boolean isbasic, int childid, float oper, int parentid, float costprice,
			float tax, float pricein, float profitpercent, float profitvalue, float priceout, List<U_Price> u_prices,
			List<U_Barcode> u_barcodes) {

		this.id = id;
		this.productid = productid;
		this.isbasic = isbasic;
		this.childid = childid;
		this.oper = oper;
		this.parentid = parentid;
		this.costprice = costprice;
		this.tax = tax;
		this.pricein = pricein;
		this.profitpercent = profitpercent;
		this.profitvalue = profitvalue;
		this.priceout = priceout;
		this.u_prices = u_prices;
		this.u_barcodes = u_barcodes;
	}

	public P_Unit() {
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
	@Column(name = "productid", nullable = false)
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@NotBlank
	@Column(name = "isbasic", nullable = false)
	public boolean isIsbasic() {
		return isbasic;
	}

	public void setIsbasic(boolean isbasic) {
		this.isbasic = isbasic;
	}

	@NotBlank
	@Column(name = "childid", nullable = false)
	public int getChildid() {
		return childid;
	}

	public void setChildid(int childid) {
		this.childid = childid;
	}

	@Column(name = "oper", nullable = true)
	public float getOper() {
		return oper;
	}

	public void setOper(float oper) {
		this.oper = oper;
	}

	@Column(name = "parentid", nullable = true)
	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

	@Column(name = "costprice", nullable = true)
	public float getCostprice() {
		return costprice;
	}

	public void setCostprice(float costprice) {
		this.costprice = costprice;
	}

	@Column(name = "tax", nullable = true)
	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	@Column(name = "pricein", nullable = true)
	public float getPricein() {
		return pricein;
	}

	public void setPricein(float pricein) {
		this.pricein = pricein;
	}

	@Column(name = "profitpercent", nullable = true)
	public float getProfitpercent() {
		return profitpercent;
	}

	public void setProfitpercent(float profitpercent) {
		this.profitpercent = profitpercent;
	}

	@Column(name = "profitvalue", nullable = true)
	public float getProfitvalue() {
		return profitvalue;
	}

	public void setProfitvalue(float profitvalue) {
		this.profitvalue = profitvalue;
	}

	@Column(name = "priceout", nullable = true)
	public float getPriceout() {
		return priceout;
	}

	public void setPriceout(float priceout) {
		this.priceout = priceout;
	}

	@OneToMany(mappedBy = "mUnit", cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "unitid")
	public List<U_Price> getU_prices() {
		return u_prices;
	}

	public void setU_prices(List<U_Price> u_prices) {
		this.u_prices = u_prices;
	}

	@OneToMany(mappedBy = "mUnit", cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "unitid")
	public List<U_Barcode> getU_barcodes() {
		return u_barcodes;
	}

	public void setU_barcodes(List<U_Barcode> u_barcodes) {
		this.u_barcodes = u_barcodes;
	}

	@OneToMany(mappedBy = "mUnit", cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "unitid")
	public List<U_Image> getU_images() {
		return u_images;
	}

	public void setU_images(List<U_Image> u_images) {
		this.u_images = u_images;
	}

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "productid", referencedColumnName = "id", insertable = false, updatable = false)
	public Product getmProduct() {
		return mProduct;
	}

	public void setmProduct(Product mProduct) {
		this.mProduct = mProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + childid;
		result = prime * result + Float.floatToIntBits(costprice);
		result = prime * result + id;
		result = prime * result + (isbasic ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(oper);
		result = prime * result + parentid;
		result = prime * result + Float.floatToIntBits(pricein);
		result = prime * result + Float.floatToIntBits(priceout);
		result = prime * result + productid;
		result = prime * result + Float.floatToIntBits(profitpercent);
		result = prime * result + Float.floatToIntBits(profitvalue);
		result = prime * result + Float.floatToIntBits(tax);
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
		P_Unit other = (P_Unit) obj;
		if (childid != other.childid)
			return false;
		if (Float.floatToIntBits(costprice) != Float.floatToIntBits(other.costprice))
			return false;
		if (id != other.id)
			return false;
		if (isbasic != other.isbasic)
			return false;
		if (Float.floatToIntBits(oper) != Float.floatToIntBits(other.oper))
			return false;
		if (parentid != other.parentid)
			return false;
		if (Float.floatToIntBits(pricein) != Float.floatToIntBits(other.pricein))
			return false;
		if (Float.floatToIntBits(priceout) != Float.floatToIntBits(other.priceout))
			return false;
		if (productid != other.productid)
			return false;
		if (Float.floatToIntBits(profitpercent) != Float.floatToIntBits(other.profitpercent))
			return false;
		if (Float.floatToIntBits(profitvalue) != Float.floatToIntBits(other.profitvalue))
			return false;
		if (Float.floatToIntBits(tax) != Float.floatToIntBits(other.tax))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "P_Unit [id=" + id + ", productid=" + productid + ", isbasic=" + isbasic + ", childid=" + childid
				+ ", oper=" + oper + ", parentid=" + parentid + ", costprice=" + costprice + ", tax=" + tax
				+ ", pricein=" + pricein + ", profitpercent=" + profitpercent + ", profitvalue=" + profitvalue
				+ ", priceout=" + priceout + "]";
	}

}
