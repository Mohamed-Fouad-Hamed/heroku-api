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
@Table(name = "base_item_device")
@SQLDelete(sql = "UPDATE base_item_device " + "SET deleted = true " + "WHERE id = ?")
@Where(clause = "deleted=false")
public class BaseItemDevice extends BaseEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @Column(name = "devicename", nullable = true, length = 50)
    private String devicename = null;

    @Column(name = "devicetype", nullable = true, length = 50)
    private String devicetype = null;

    @Column(name = "macaddress", nullable = true, length = 17)
    private String macaddress = null;

    @Column(name = "ipaddress", nullable = true, length = 23)
    private String ipaddress = null;

    @Column(name = "portnumber", nullable = true, length = 6)
    private String portnumber = null;

    @Override
    public String toString() {
        return "BaseItemDevice [devicename=" + devicename + ", devicetype=" + devicetype + "]";
    }

    public String getDevicename() {
        return devicename;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((devicetype == null) ? 0 : devicetype.hashCode());
        result = prime * result + ((ipaddress == null) ? 0 : ipaddress.hashCode());
        result = prime * result + ((macaddress == null) ? 0 : macaddress.hashCode());
        result = prime * result + ((portnumber == null) ? 0 : portnumber.hashCode());
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
        BaseItemDevice other = (BaseItemDevice) obj;
        if (devicetype == null) {
            if (other.devicetype != null)
                return false;
        } else if (!devicetype.equals(other.devicetype))
            return false;
        if (ipaddress == null) {
            if (other.ipaddress != null)
                return false;
        } else if (!ipaddress.equals(other.ipaddress))
            return false;
        if (macaddress == null) {
            if (other.macaddress != null)
                return false;
        } else if (!macaddress.equals(other.macaddress))
            return false;
        if (portnumber == null) {
            if (other.portnumber != null)
                return false;
        } else if (!portnumber.equals(other.portnumber))
            return false;
        return true;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getPortnumber() {
        return portnumber;
    }

    public void setPortnumber(String portnumber) {
        this.portnumber = portnumber;
    }

}