package alf.api.web.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "base_item_production")
@SQLDelete(sql = "UPDATE base_item_production " +
        "SET deleted = true " +
        "WHERE id = ?")
@Where(clause = "deleted=false")
public class BaseItemProduction extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "nickname", nullable = true, length = 50)
    private String nickname = null;

    @Column(name = "barcode", nullable = true, length = 20)
    private String barcode = null;

    @Column(name = "orderlimit", nullable = true)
    private float orderlimit = 0.0f;

    @Column(name = "category_id", nullable = true)
    private long category_id = 0L;

    @Column(name = "group_id", nullable = true)
    private long group_id = 0L;

    @Column(name = "whole_id", nullable = true)
    private long whole_id = 0L;

    @Column(name = "factor", nullable = true)
    private float factor = 0.0f;

    @Column(name = "segment_id", nullable = true)
    private long segment_id = 0L;

    @Column(name = "pricebuy", nullable = true)
    private float pricebuy = 0.0f;

    @Column(name = "pricesell", nullable = true)
    private float pricesell = 0.0f;

    @Column(name = "stockcost", nullable = true)
    private float stockcost = 0.0f;

    @Column(name = "stockvolume", nullable = true)
    private float stockvolume = 0.0f;

    @Column(name = "taxable", nullable = true)
    private boolean taxable = false;

    @Column(name = "tax_percent", nullable = true)
    private float tax_percent = 0.0f;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_item_id")
    @JsonIgnore
    private BaseItem item;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public float getOrderlimit() {
        return orderlimit;
    }

    public void setOrderlimit(float orderlimit) {
        this.orderlimit = orderlimit;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public long getWhole_id() {
        return whole_id;
    }

    public void setWhole_id(long whole_id) {
        this.whole_id = whole_id;
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    public long getSegment_id() {
        return segment_id;
    }

    public void setSegment_id(long segment_id) {
        this.segment_id = segment_id;
    }

    public float getPricebuy() {
        return pricebuy;
    }

    public void setPricebuy(float pricebuy) {
        this.pricebuy = pricebuy;
    }

    public float getPricesell() {
        return pricesell;
    }

    public void setPricesell(float pricesell) {
        this.pricesell = pricesell;
    }

    public float getStockcost() {
        return stockcost;
    }

    public void setStockcost(float stockcost) {
        this.stockcost = stockcost;
    }

    public float getStockvolume() {
        return stockvolume;
    }

    public void setStockvolume(float stockvolume) {
        this.stockvolume = stockvolume;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public float getTax_percent() {
        return tax_percent;
    }

    public void setTax_percent(float tax_percent) {
        this.tax_percent = tax_percent;
    }

    public BaseItem getItem() {
        return item;
    }

    public void setItem(BaseItem item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((barcode == null) ? 0 : barcode.hashCode());
        result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
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
        BaseItemProduction other = (BaseItemProduction) obj;
        if (barcode == null) {
            if (other.barcode != null)
                return false;
        } else if (!barcode.equals(other.barcode))
            return false;
        if (nickname == null) {
            if (other.nickname != null)
                return false;
        } else if (!nickname.equals(other.nickname))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BaseItemProduction [barcode=" + barcode + ", nickname=" + nickname + "]";
    }

}