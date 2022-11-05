package com.cloth_management.Repository;

import com.cloth_management.Models.Category;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {
    JdbcTemplate jdbcTemplate;


    @Override
    public boolean AddCategory(Category category) {
        return false;
    }

    @Override
    public boolean DeleteCategory(Category category) {
        return false;
    }

    @Override
    public boolean UpdateCategory(Category category) {
        return false;
    }

    @Override
    public List<Category> ListCategories() {
        return null;
    }

    @Override
    public Category GetCategory(int cat_id) {
        return null;
    }
}
