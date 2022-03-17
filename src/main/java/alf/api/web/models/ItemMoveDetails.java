package alf.api.web.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "item_move_details")
@SQLDelete(sql = "UPDATE item_move_details " + "SET deleted = true " + "WHERE id = ?")
@Where(clause = "deleted=true")
public class ItemMoveDetails extends BaseEntity<String> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 811220603925369804L;

    @Column(name = "product_id", nullable = true)
    private long product_id = 0L;

    @Column(name = "whole_id", nullable = true)
    private long whole_id = 0L;

    @Column(name = "factor", nullable = true)
    private float factor = 0.0f;

    @Column(name = "segement_id", nullable = true)
    private long segement_id = 0L;

    @Column(name = "quantity", nullable = true)
    private float quantity = 0.0f;

    @Column(name = "quantity_s", nullable = true)
    private float quantity_s = 0.0f;

    @Column(name = "price_buy", nullable = true)
    private float price_buy = 0.0f;

    @Column(name = "price_buy_s", nullable = true)
    private float price_buy_s = 0.0f;

    @Column(name = "total_buy", nullable = true)
    private float total_buy = 0.0f;

    @Column(name = "price_sell", nullable = true)
    private float price_sell = 0.0f;

    @Column(name = "price_sell_s", nullable = true)
    private float price_sell_s = 0.0f;

    @Column(name = "tax_per", nullable = true)
    private float tax_per = 0.0f;

    @Column(name = "disc_per", nullable = true)
    private float disc_per = 0.0f;

    @Column(name = "tax_val", nullable = true)
    private float tax_val = 0.0f;

    @Column(name = "disc_val", nullable = true)
    private float disc_val = 0.0f;

    @Column(name = "notes", nullable = true, length = 30)
    private String notes = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemmove_id")
    @JsonIgnore
    private ItemMove itemmove;

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
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

    public long getSegement_id() {
        return segement_id;
    }

    public void setSegement_id(long segement_id) {
        this.segement_id = segement_id;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getQuantity_s() {
        return quantity_s;
    }

    public void setQuantity_s(float quantity_s) {
        this.quantity_s = quantity_s;
    }

    public float getPrice_buy() {
        return price_buy;
    }

    public void setPrice_buy(float price_buy) {
        this.price_buy = price_buy;
    }

    public float getPrice_buy_s() {
        return price_buy_s;
    }

    public void setPrice_buy_s(float price_buy_s) {
        this.price_buy_s = price_buy_s;
    }

    public float getTotal_buy() {
        return total_buy;
    }

    public void setTotal_buy(float value_buy) {
        this.total_buy = value_buy;
    }

    public float getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(float price_sell) {
        this.price_sell = price_sell;
    }

    public float getPrice_sell_s() {
        return price_sell_s;
    }

    public void setPrice_sell_s(float price_sell_s) {
        this.price_sell_s = price_sell_s;
    }

    public float getTax_per() {
        return tax_per;
    }

    public void setTax_per(float tax_per) {
        this.tax_per = tax_per;
    }

    public float getDisc_per() {
        return disc_per;
    }

    public void setDisc_per(float disc_per) {
        this.disc_per = disc_per;
    }

    public float getTax_val() {
        return tax_val;
    }

    public void setTax_val(float tax_val) {
        this.tax_val = tax_val;
    }

    public float getDisc_val() {
        return disc_val;
    }

    public void setDisc_val(float disc_val) {
        this.disc_val = disc_val;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ItemMove getItemmove() {
        return itemmove;
    }

    public void setItemmove(ItemMove itemmove) {
        this.itemmove = itemmove;
    }

}