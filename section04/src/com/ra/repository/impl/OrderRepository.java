package com.ra.repository.impl;

import com.ra.entity.Category;
import com.ra.entity.Order;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class OrderRepository extends Repository<Order, Integer> {
    public OrderRepository() {
        this.clazz = Order.class;
        this.sp_findAll = "{call sp_orders_findAll()}";
        this.sp_findId = "{call sp_orders_findId(?)}";
        this.sp_insert = "{call sp_orders_add(?,?,?,?,?)}";
        this.sp_update = "{call sp_orders_update(?,?,?,?,?)}";
        this.sp_delete = "{call sp_orders_delete(?)}";
    }

    @Override
    public void setInsertParam(CallableStatement cs, Order entity) throws SQLException {

    }

    @Override
    public void setUpdateParam(CallableStatement cs, Order entity) throws SQLException {

    }

    @Override
    public void handleInsert(CallableStatement cs, Order entity) throws SQLException {

    }

    @Override
    public void handleUpdate(CallableStatement cs, Order entity) throws SQLException {

    }
}