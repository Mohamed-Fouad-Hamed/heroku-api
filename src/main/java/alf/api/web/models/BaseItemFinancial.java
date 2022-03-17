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
@Table(name = "base_item_financial")
@SQLDelete(sql = "UPDATE Base_Item_financial " +
        "SET deleted = true " +
        "WHERE id = ?")
@Where(clause = "deleted=false")
public class BaseItemFinancial extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "trademark", nullable = true, length = 50)
    private String trademark = null;

    @Column(name = "store_account_balance", nullable = true)
    private float store_account_balance = 0.0f;

    @Column(name = "account", nullable = true)
    private long account = 0L;

    @Column(name = "taxable", nullable = true)
    private boolean taxable = false;

    @Column(name = "tax_percent", nullable = true)
    private float tax_percent = 0.0f;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_item_id")
    @JsonIgnore
    private BaseItem item;

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public float getStore_account_balance() {
        return store_account_balance;
    }

    public void setStore_account_balance(float store_account_balance) {
        this.store_account_balance = store_account_balance;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
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
        result = prime * result + (int) (account ^ (account >>> 32));
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        result = prime * result + ((trademark == null) ? 0 : trademark.hashCode());
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
        BaseItemFinancial other = (BaseItemFinancial) obj;
        if (account != other.account)
            return false;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        if (trademark == null) {
            if (other.trademark != null)
                return false;
        } else if (!trademark.equals(other.trademark))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BaseItemFinancial [account=" + account + ", item=" + item + ", trademark=" + trademark + "]";
    }

}