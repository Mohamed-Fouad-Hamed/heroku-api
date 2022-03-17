package alf.api.web.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "company_info")
@SQLDelete(sql = "UPDATE company_info " + "SET deleted = true " + "WHERE id = ?")
@Where(clause = "deleted=false")
public class CompanyInfo extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false, length = 70)
    private String name = null;

    @Column(name = "trademark", nullable = true, length = 70)
    private String trademark = null;

    @Column(name = "website", nullable = true, length = 50)
    private String website = null;

    @Column(name = "email", nullable = true, length = 50)
    private String email = null;

    @Column(name = "address", nullable = true, length = 255)
    private String address = null;

    @Column(name = "city", nullable = true, length = 30)
    private String city = null;

    @Column(name = "country", nullable = true, length = 30)
    private String country = null;

    @Column(name = "language", nullable = true, length = 15)
    private String language = null;

    @Column(name = "currency", nullable = true, length = 15)
    private String currency = null;

    @Column(name = "postalcode", nullable = true, length = 20)
    private String postalcode = null;

    @Column(name = "phone", nullable = true, length = 25)
    private String phone = null;

    @Column(name = "mobil", nullable = true, length = 25)
    private String mobil = null;

    @Column(name = "fax", nullable = true, length = 25)
    private String fax = null;

    @Column(name = "commercialrecord", nullable = true, length = 25)
    private String commercialrecord;

    @Column(name = "taxcard", nullable = true, length = 25)
    private String taxcard;

    @Column(name = "logo", columnDefinition = "text", length = 65535)
    private String logo;

    @Column(name = "watermark", columnDefinition = "text", length = 65535)
    private String watermark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getCommercialrecord() {
        return commercialrecord;
    }

    public void setCommercialrecord(String commercialrecord) {
        this.commercialrecord = commercialrecord;
    }

    public String getTaxcard() {
        return taxcard;
    }

    public void setTaxcard(String taxcard) {
        this.taxcard = taxcard;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((language == null) ? 0 : language.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        CompanyInfo other = (CompanyInfo) obj;
        if (language == null) {
            if (other.language != null)
                return false;
        } else if (!language.equals(other.language))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
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
        return "CompanyInfo [language=" + language + ", name=" + name + ", trademark=" + trademark + "]";
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}