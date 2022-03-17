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
@Table(name = "base_item_document")
@SQLDelete(sql = "UPDATE base_item_document " +
        "SET deleted = true " +
        "WHERE id = ?")
@Where(clause = "deleted=false")
public class BaseItemDocument extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "documentname", nullable = true, length = 50)
    private String documentname = null;

    @Column(name = "store_effect", nullable = true)
    private long store_effect = 0L;

    @Column(name = "account_effect", nullable = true)
    private long account_effect = 0L;

    // @Column(name="first_effect",nullable=true)
    // private byte first_effect = 0;

    @Column(name = "has_base_item_first", nullable = true)
    private boolean has_base_item_first = false;

    @Column(name = "base_item_type_first", nullable = true, length = 255)
    private String base_item_type_first = null;

    // @Column(name="second_effect",nullable=true)
    // private byte second_effect = 0;

    @Column(name = "has_base_item_second", nullable = true)
    private boolean has_base_item_second = false;

    @Column(name = "base_item_type_second", nullable = true, length = 255)
    private String base_item_type_second = null;

    @Column(name = "appear_stock", nullable = true)
    private boolean appear_stock = false;

    @Column(name = "out_no_stock", nullable = true)
    private boolean out_no_stock = false;

    @Column(name = "default_in_price", nullable = true)
    private boolean default_in_price = false;

    @Column(name = "default_out_price", nullable = true)
    private boolean default_out_price = false;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_item_id")
    @JsonIgnore
    private BaseItem item;

    public String getDocumentname() {
        return documentname;
    }

    public void setDocumentname(String documentname) {
        this.documentname = documentname;
    }

    public long getStore_effect() {
        return store_effect;
    }

    public void setStore_effect(long store_effect) {
        this.store_effect = store_effect;
    }

    public long getAccount_effect() {
        return account_effect;
    }

    public void setAccount_effect(long account_effect) {
        this.account_effect = account_effect;
    }

    public boolean isHas_base_item_first() {
        return has_base_item_first;
    }

    public void setHas_base_item_first(boolean has_base_item_first) {
        this.has_base_item_first = has_base_item_first;
    }

    public String getBase_item_type_first() {
        return base_item_type_first;
    }

    public void setBase_item_type_first(String base_item_type_first) {
        this.base_item_type_first = base_item_type_first;
    }

    public boolean isHas_base_item_second() {
        return has_base_item_second;
    }

    public void setHas_base_item_second(boolean has_base_item_second) {
        this.has_base_item_second = has_base_item_second;
    }

    public String getBase_item_type_second() {
        return base_item_type_second;
    }

    public void setBase_item_type_second(String base_item_type_second) {
        this.base_item_type_second = base_item_type_second;
    }

    public boolean isAppear_stock() {
        return appear_stock;
    }

    public void setAppear_stock(boolean appear_stock) {
        this.appear_stock = appear_stock;
    }

    public boolean isOut_no_stock() {
        return out_no_stock;
    }

    public void setOut_no_stock(boolean out_no_stock) {
        this.out_no_stock = out_no_stock;
    }

    public boolean isDefault_in_price() {
        return default_in_price;
    }

    public void setDefault_in_price(boolean default_in_price) {
        this.default_in_price = default_in_price;
    }

    public boolean isDefault_out_price() {
        return default_out_price;
    }

    public void setDefault_out_price(boolean default_out_price) {
        this.default_out_price = default_out_price;
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
        result = prime * result + ((documentname == null) ? 0 : documentname.hashCode());
        result = prime * result + ((item == null) ? 0 : item.hashCode());
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
        BaseItemDocument other = (BaseItemDocument) obj;
        if (documentname == null) {
            if (other.documentname != null)
                return false;
        } else if (!documentname.equals(other.documentname))
            return false;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BaseItemDocument [documentname=" + documentname + "]";
    }

}