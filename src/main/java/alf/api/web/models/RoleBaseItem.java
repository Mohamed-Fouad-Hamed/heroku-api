package alf.api.web.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role_baseitem")
public class RoleBaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id = 0;

    @Column(name = "baseitem_id", nullable = false)
    private long baseitem_id = 0;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "baseitemtype_id")
    @JsonIgnore
    private RoleBaseItemType baseitemtype;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBaseitem_id() {
        return baseitem_id;
    }

    public void setBaseitem_id(long baseitem_id) {
        this.baseitem_id = baseitem_id;
    }

    public RoleBaseItemType getBaseitemtype() {
        return baseitemtype;
    }

    public void setBaseitemtype(RoleBaseItemType baseitemtype) {
        this.baseitemtype = baseitemtype;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((baseitemtype == null) ? 0 : baseitemtype.hashCode());
        result = prime * result + (int) (baseitem_id ^ (baseitem_id >>> 32));
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "RoleBaseItem [baseitemtype=" + baseitemtype + ", baseitemtype_id=" + baseitem_id + ", id=" + id
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RoleBaseItem other = (RoleBaseItem) obj;
        if (baseitemtype == null) {
            if (other.baseitemtype != null)
                return false;
        } else if (!baseitemtype.equals(other.baseitemtype))
            return false;
        if (baseitem_id != other.baseitem_id)
            return false;
        if (id != other.id)
            return false;
        return true;
    }

}