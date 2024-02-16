package com.ra.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Order implements IEntity {
    private int id;
    private int customerId;
    private float total;
    private Date created;
    private boolean status;

    public Order() {
    }

    public Order(int id, int customerId, float total, Date created, boolean status) {
        this.id = id;
        this.customerId = customerId;
        this.total = total;
        this.created = created;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void init(ResultSet rs) throws SQLException {

    }
}