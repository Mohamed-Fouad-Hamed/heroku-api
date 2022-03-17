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
@Table(name = "base_item_pointsale")
@SQLDelete(sql = "UPDATE base_item_pointsale " + "SET deleted = true " + "WHERE id = ?")
@Where(clause = "deleted=false")
public class BaseItemPointSale extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pointsalename", nullable = true, length = 50)
    private String pointsalename = null;

    @Column(name = "pointsaletype", nullable = true, length = 50)
    private String pointsaletype = null;

    @Column(name = "store_id", nullable = true)
    private long store_id = 0L;

    @Column(name = "cashier_id", nullable = true)
    private long cashier_id = 0L;

    @Column(name = "brunch_id", nullable = true)
    private long brunch_id = 0L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_item_id")
    @JsonIgnore
    private BaseItem item;

    public BaseItem getItem() {
        return item;
    }

    public void setItem(BaseItem item) {
        this.item = item;
    }

    public String getPointsalename() {
        return pointsalename;
    }

    @Override
    public String toString() {
        return "BaseItemPointSale [pointsalename=" + pointsalename + ", pointsaletype=" + pointsaletype + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (brunch_id ^ (brunch_id >>> 32));
        result = prime * result + (int) (cashier_id ^ (cashier_id >>> 32));
        result = prime * result + ((pointsalename == null) ? 0 : pointsalename.hashCode());
        result = prime * result + ((pointsaletype == null) ? 0 : pointsaletype.hashCode());
        result = prime * result + (int) (store_id ^ (store_id >>> 32));
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
        BaseItemPointSale other = (BaseItemPointSale) obj;
        if (brunch_id != other.brunch_id)
            return false;
        if (cashier_id != other.cashier_id)
            return false;
        if (pointsalename == null) {
            if (other.pointsalename != null)
                return false;
        } else if (!pointsalename.equals(other.pointsalename))
            return false;
        if (pointsaletype == null) {
            if (other.pointsaletype != null)
                return false;
        } else if (!pointsaletype.equals(other.pointsaletype))
            return false;
        if (store_id != other.store_id)
            return false;
        return true;
    }

    public void setPointsalename(String pointsalename) {
        this.pointsalename = pointsalename;
    }

    public String getPointsaletype() {
        return pointsaletype;
    }

    public void setPointsaletype(String pointsaletype) {
        this.pointsaletype = pointsaletype;
    }

    public long getStore_id() {
        return store_id;
    }

    public void setStore_id(long store_id) {
        this.store_id = store_id;
    }

    public long getCashier_id() {
        return cashier_id;
    }

    public void setCashier_id(long cashier_id) {
        this.cashier_id = cashier_id;
    }

    public long getBrunch_id() {
        return brunch_id;
    }

    public void setBrunch_id(long brunch_id) {
        this.brunch_id = brunch_id;
    }

}