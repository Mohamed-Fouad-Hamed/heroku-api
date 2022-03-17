package alf.api.web.models;

import java.sql.Timestamp;
import java.util.Date;

public class ItemMoveSearcher {

    private Long id;
    private boolean deleted;
    private long document_id;
    private long first_id;
    private long second_id;
    private String store_keeper;
    private String order_supply_number;
    private String transporter_name;
    private String vehicle_number;
    private String driver_name;
    private String order_work_number;
    private Date order_date_start;
    private Date order_date_end;
    private Timestamp order_time_in_start;
    private Timestamp order_time_in_end;
    private Timestamp order_time_out_start;
    private Timestamp order_time_out_end;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

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

    public Date getOrder_date_start() {
        return order_date_start;
    }

    public void setOrder_date_start(Date order_date_start) {
        this.order_date_start = order_date_start;
    }

    public Date getOrder_date_end() {
        return order_date_end;
    }

    public void setOrder_date_end(Date order_date_end) {
        this.order_date_end = order_date_end;
    }

    public Timestamp getOrder_time_in_start() {
        return order_time_in_start;
    }

    public void setOrder_time_in_start(Timestamp order_time_in_start) {
        this.order_time_in_start = order_time_in_start;
    }

    public Timestamp getOrder_time_in_end() {
        return order_time_in_end;
    }

    public void setOrder_time_in_end(Timestamp order_time_in_end) {
        this.order_time_in_end = order_time_in_end;
    }

    public Timestamp getOrder_time_out_start() {
        return order_time_out_start;
    }

    public void setOrder_time_out_start(Timestamp order_time_out_start) {
        this.order_time_out_start = order_time_out_start;
    }

    public Timestamp getOrder_time_out_end() {
        return order_time_out_end;
    }

    public void setOrder_time_out_end(Timestamp order_time_out_end) {
        this.order_time_out_end = order_time_out_end;
    }

}