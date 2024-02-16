package com.ra.repository.impl;

import com.ra.entity.Category;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

public class CategoryRepository extends Repository<Category, Integer>{
    public CategoryRepository() {
        this.clazz = Category.class;
        this.sp_findAll = "{call sp_categories_findAll()}";
        this.sp_findId = "{call sp_categories_findId(?)}";
        this.sp_insert = "{call sp_categories_add(?,?,?,?,?)}";
        this.sp_update = "{call sp_categories_update(?,?,?,?,?)}";
        this.sp_delete = "{call sp_categories_delete(?)}";
    }

    @Override
    public void setInsertParam(CallableStatement cs, Category entity) throws SQLException {
        cs.registerOutParameter(1, Types.INTEGER);
        cs.setString(2, entity.getName());
        cs.setString(3, entity.getKeyword());
        cs.setString(4, entity.getDescription());
        cs.setBoolean(5, entity.isStatus());
    }

    @Override
    public void setUpdateParam(CallableStatement cs, Category entity) throws SQLException {
        cs.setInt(1, entity.getId());
        cs.setString(2, entity.getName());
        cs.setString(3, entity.getKeyword());
        cs.setString(4, entity.getDescription());
        cs.setBoolean(5, entity.isStatus());
    }

    @Override
    public void handleInsert(CallableStatement cs, Category entity) throws SQLException {
        entity.setId(cs.getInt(1));
    }

    @Override
    public void handleUpdate(CallableStatement cs, Category entity) throws SQLException {

    }
    @Override
    public Category edit(Category entity) throws SQLException {
        try (Connection conn = MySQLConnect.open();
             CallableStatement cs = conn.prepareCall(sp_update)) {
            setUpdateParam(cs, entity);
            cs.execute();
        }
        return entity;
    }

    @Override
    public boolean remove(Integer id) throws SQLException {
        try (Connection conn = MySQLConnect.open();
             CallableStatement cs = conn.prepareCall(sp_delete)) {
            cs.setInt(1, id);
            return cs.executeUpdate() > 0;
        }
    }

}