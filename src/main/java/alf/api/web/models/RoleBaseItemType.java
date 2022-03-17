package alf.api.web.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "role_baseitemtype")
public class RoleBaseItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id = 0;

    @Column(name = "baseitemtype_id", nullable = false)
    private long baseitemtype_id = 0;

    @Column(name = "all_allow")
    private boolean all_allow = false;

    @Column(name = "not_allow")
    private boolean not_allow = false;

    @Column(name = "some_allow")
    private boolean some_allow = false;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    @JsonIgnore
    private Role role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baseitemtype", orphanRemoval = true)
    private List<RoleBaseItem> role_baseitem = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBaseitemtype_id() {
        return baseitemtype_id;
    }

    public void setBaseitemtype_id(long baseitemtype_id) {
        this.baseitemtype_id = baseitemtype_id;
    }

    public boolean isAll_allow() {
        return all_allow;
    }

    public void setAll_allow(boolean all_allow) {
        this.all_allow = all_allow;
    }

    public boolean isNot_allow() {
        return not_allow;
    }

    public void setNot_allow(boolean not_allow) {
        this.not_allow = not_allow;
    }

    public boolean isSome_allow() {
        return some_allow;
    }

    public void setSome_allow(boolean some_allow) {
        this.some_allow = some_allow;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<RoleBaseItem> getRole_baseitem() {
        return role_baseitem;
    }

    public void setRole_baseitem(List<RoleBaseItem> role_baseitem) {
        this.role_baseitem = role_baseitem;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (baseitemtype_id ^ (baseitemtype_id >>> 32));
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + (not_allow ? 1231 : 1237);
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + (some_allow ? 1231 : 1237);
        return result;
    }

    @Override
    public String toString() {
        return "RoleBaseItemType [baseitemtype_id=" + baseitemtype_id + ", id=" + id + ", not_allow=" + not_allow
                + ", role=" + role + ", some_allow=" + some_allow + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RoleBaseItemType other = (RoleBaseItemType) obj;
        if (baseitemtype_id != other.baseitemtype_id)
            return false;
        if (id != other.id)
            return false;
        if (not_allow != other.not_allow)
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (some_allow != other.some_allow)
            return false;
        return true;
    }

}
