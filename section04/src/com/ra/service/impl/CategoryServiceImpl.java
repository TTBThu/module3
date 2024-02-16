package com.ra.service.impl;

import com.ra.entity.Category;
import com.ra.service.CategoryService;
import com.ra.util.MySQLConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() {
        List<Category> result = new ArrayList<>();
        Connection conn = null;
        try {
            // B1. Tạo kết nối
            conn = MySQLConnect.open();
            // B2. Tạo đối tượng thực thi câu truy vấn
//            String query = "SELECT * FROM categories";
            String query = "{call sp_categories_findAll()}";
//            PreparedStatement ps = conn.prepareStatement(query);
            CallableStatement cs = conn.prepareCall(query);
            // B3. Thực thi câu truy vấn
            ResultSet rs = cs.executeQuery();
            // B4. Xử lý ResultSet
            while (rs.next()) {
                Category c = new Category(rs);
                result.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            MySQLConnect.close(conn);
        }
        return result;
    }

    @Override
    public List<Category> findByName(String name) {
        List<Category> result = new ArrayList<>();
        Connection conn = null;
        try {
            // B1. Tạo kết nối
            conn = MySQLConnect.open();
            // B2. Tạo đối tượng thực thi câu truy vấn
            String query = "SELECT * FROM categories WHERE name like ?";
            PreparedStatement ps = conn.prepareStatement(query);
            // B2.1: Truyền tham số nếu có
            ps.setString(1, "%"+name+"%");
            // B3. Thực thi câu truy vấn
            ResultSet rs = ps.executeQuery();
            // B4. Xử lý ResultSet
            while (rs.next()) {
                Category c = new Category(rs);
                result.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            MySQLConnect.close(conn);
        }
        return result;
    }

    @Override
    public Category findId(int id) {
        Connection conn = null;
        try {
            // B1. Tạo kết nối
            conn = MySQLConnect.open();
            // B2. Tạo đối tượng thực thi câu truy vấn
            String query = "{call sp_categories_findId(?)}";
            CallableStatement cs = conn.prepareCall(query);
            // B2.1: Truyền tham số nếu có
            cs.setInt(1, id);
            // B3. Thực thi câu truy vấn
            ResultSet rs = cs.executeQuery();
            // B4. Xử lý ResultSet
            while (rs.next()) {
                Category c = new Category(rs);
                return c;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            MySQLConnect.close(conn);
        }
        return null;
    }

    @Override
    public Category insert(Category category) {
        Connection conn = null;
        try {
            // B1. Tạo kết nối
            conn = MySQLConnect.open();
            //Tắt tính năng tự động commit
            conn.setAutoCommit(false);
            // B2. Tạo đối tượng thực thi câu truy vấn
            //String query = "INSERT INTO categories(name,keyword,description,status) VALUES(?,?,?,?)";
            String query = "{ call sp_categories_add(?,?,?,?,?)}";
            //PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            CallableStatement cs = conn.prepareCall(query);
            // B2.1: Truyền tham số nếu có
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, category.getName());
            cs.setString(3, category.getKeyword());
            cs.setString(4, category.getDescription());
            cs.setBoolean(5, category.isStatus());
            // B3. Thực thi câu truy vấn
            int result = cs.executeUpdate();
            if (result > 0) {
                category.setId(cs.getInt(1));
            }
            // Đẩy các thay đổi xuống database
            conn.commit();
            return category;
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                // Hoàn tác lại các thay đổi
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } finally {
            MySQLConnect.close(conn);
        }
        return null;
    }

    @Override
    public Category update(Category category) {
        Connection conn = null;
        try {
            conn = MySQLConnect.open();
            String query = "{ call sp_categories_update(?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(query);
            cs.setInt(1, category.getId());
            cs.setString(2, category.getName());
            cs.setString(3, category.getKeyword());
            cs.setString(4, category.getDescription());
            cs.setBoolean(5, category.isStatus());
            cs.executeUpdate();
            return category;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            MySQLConnect.close(conn);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        try {
            conn = MySQLConnect.open();
            String query = "{ call sp_categories_delete(?)}";
            CallableStatement cs = conn.prepareCall(query);
            cs.setInt(1, id);
            return cs.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            MySQLConnect.close(conn);
        }
        return false;
    }
}