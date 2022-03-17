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
@Table(name = "base_item_info")
@SQLDelete(sql = "UPDATE Base_Item_info " +
        "SET deleted = true " +
        "WHERE id = ?")
@Where(clause = "deleted=false")
public class BaseItemInfo extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "secondname", nullable = true, length = 70)
    private String secondname = null;

    @Column(name = "email", nullable = true, length = 50)
    private String email = null;

    @Column(name = "address", nullable = true, length = 255)
    private String address = null;

    @Column(name = "city", nullable = true, length = 30)
    private String city = null;

    @Column(name = "country", nullable = true, length = 30)
    private String country = null;

    @Column(name = "postalcode", nullable = true, length = 20)
    private String postalcode = null;

    @Column(name = "phone", nullable = true, length = 25)
    private String phone = null;

    @Column(name = "mobil", nullable = true, length = 25)
    private String mobil = null;

    @Column(name = "fax", nullable = true, length = 25)
    private String fax = null;

    @Column(name = "comments", nullable = true, length = 255)
    private String comments = null;

    @Column(name = "notes", nullable = true, length = 255)
    private String notes = null;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_item_id")
    @JsonIgnore
    private BaseItem item;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BaseItem getItem() {
        return item;
    }

    public void setType(BaseItem item) {
        this.item = item;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setItem(BaseItem item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        result = prime * result + ((secondname == null) ? 0 : secondname.hashCode());
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
        BaseItemInfo other = (BaseItemInfo) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        if (secondname == null) {
            if (other.secondname != null)
                return false;
        } else if (!secondname.equals(other.secondname))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BaseItemInfo [email=" + email + ", item=" + item + ", secondname=" + secondname + "]";
    }

}