package com.ra.service;

import com.ra.entity.Category;

import java.util.List;
import java.util.ArrayList;

public interface CategoryService {
    List<Category> findAll();
    List<Category> findByName(String name);
    Category findId(int id);
    Category insert(Category category);
    Category update(Category category);
    boolean delete(int id);
}
