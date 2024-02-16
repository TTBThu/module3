package com.ra.entity;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class Category implements IEntity {
    private int id;
    private String name;
    private String keyword;
    private String description;
    private boolean status;

    public Category() {
    }
    public Category(ResultSet rs) throws SQLException {
        setId(rs.getInt("id"));
        setName(rs.getString("name"));
        setKeyword(rs.getString("keyword"));
        setDescription(rs.getString("description"));
        setStatus(rs.getBoolean("status"));
    }

    public Category(int id, String name, String keyword, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.keyword = keyword;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void init(ResultSet rs) throws SQLException {
        setId(rs.getInt("id"));
        setName(rs.getString("name"));
        setKeyword(rs.getString("keyword"));
        setDescription(rs.getString("description"));
        setStatus(rs.getBoolean("status"));
    }
}