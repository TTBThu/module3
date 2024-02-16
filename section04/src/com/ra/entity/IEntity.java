package com.ra.entity;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IEntity {
    void init(ResultSet rs) throws SQLException;
}