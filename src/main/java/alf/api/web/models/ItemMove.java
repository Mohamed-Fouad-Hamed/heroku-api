package alf.api.web.models;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "Item_Move")
@SQLDelete(sql = "UPDATE Item_Move " + "SET deleted = true " + "WHERE id = ?")
@Where(clause = "deleted=true")
public class ItemMove extends BaseEntity<String> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "document_id", nullable = true)
    private long document_id;

    @Column(name = "first_id", nullable = true)
    private long first_id;

    @Column(name = "second_id", nullable = true)
    private long second_id;

    @Column(name = "pos_id", nullable = true)
    private long pos_id;

    @Column(name = "store_keeper", nullable = true, length = 20)
    private String store_keeper;

    @Column(name = "order_supply_number", nullable = true, length = 15)
    private String order_supply_number;

    @Column(name = "transporter_name", nullable = true, length = 20)
    private String transporter_name;

    @Column(name = "vehicle_number", nullable = true, length = 10)
    private String vehicle_number;

    @Column(name = "driver_name", nullable = true, length = 20)
    private String driver_name;

    @Column(name = "order_work_number", nullable = true, length = 15)
    private String order_work_number;

    @Column(name = "order_date", nullable = true)
    private Date order_date;

    @Column(name = "order_time_in", nullable = true)
    private Timestamp order_time_in;

    @Column(name = "order_time_out", nullable = true)
    private Timestamp order_time_out;

    @Column(name = "total_disc", nullable = true)
    private float total_disc = 0.0f;

    @Column(name = "total_tax", nullable = true)
    private float total_tax = 0.0f;

    @Column(name = "total_due", nullable = true)
    private float total_due = 0.0f;

    @Column(name = "net_due", nullable = true)
    private float net_due = 0.0f;

    @Column(name = "payment", nullable = true)
    private float payment = 0.0f;

    @Column(name = "remainder", nullable = true)
    private float remainder = 0.0f;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemmove", orphanRemoval = true)
    private List<ItemMoveDetails> itemmovedetails = new ArrayList<>();

    public long getDocument_id() {
        return document_id;
    }

    public void setDocument_id(long document_id) {
        this.document_id = document_id;
    }

    public long getFirst_id() {
        return first_id;
    }

    public void setFirst_id(long first_id) {
        this.first_id = first_id;
    }

    public long getSecond_id() {
        return second_id;
    }

    public void setSecond_id(long second_id) {
        this.second_id = second_id;
    }

    public String getStore_keeper() {
        return store_keeper;
    }

    public void setStore_keeper(String store_keeper) {
        this.store_keeper = store_keeper;
    }

    public String getOrder_supply_number() {
        return order_supply_number;
    }

    public void setOrder_supply_number(String order_supply_number) {
        this.order_supply_number = order_supply_number;
    }

    public String getTransporter_name() {
        return transporter_name;
    }

    public void setTransporter_name(String transporter_name) {
        this.transporter_name = transporter_name;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getOrder_work_number() {
        return order_work_number;
    }

    public void setOrder_work_number(String order_work_number) {
        this.order_work_number = order_work_number;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Timestamp getOrder_time_in() {
        return order_time_in;
    }

    public void setOrder_time_in(Timestamp order_time_in) {
        this.order_time_in = order_time_in;
    }

    public Timestamp getOrder_time_out() {
        return order_time_out;
    }

    public void setOrder_time_out(Timestamp order_time_out) {
        this.order_time_out = order_time_out;
    }

    public List<ItemMoveDetails> getItemmovedetails() {
        return itemmovedetails;
    }

    public void setItemmovedetails(List<ItemMoveDetails> itemmovedetails) {
        this.itemmovedetails = itemmovedetails;
    }

    public float getTotal_disc() {
        return total_disc;
    }

    public void setTotal_disc(float total_disc) {
        this.total_disc = total_disc;
    }

    public float getTotal_tax() {
        return total_tax;
    }

    public void setTotal_tax(float total_tax) {
        this.total_tax = total_tax;
    }

    public float getTotal_due() {
        return total_due;
    }

    public void setTotal_due(float total_due) {
        this.total_due = total_due;
    }

    public float getNet_due() {
        return net_due;
    }

    public void setNet_due(float net_due) {
        this.net_due = net_due;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public float getRemainder() {
        return remainder;
    }

    public void setRemainder(float remainder) {
        this.remainder = remainder;
    }

    public long getPos_id() {
        return pos_id;
    }

    public void setPos_id(long pos_id) {
        this.pos_id = pos_id;
    }

}