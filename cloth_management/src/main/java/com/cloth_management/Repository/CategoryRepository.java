package com.cloth_management.Repository;

import com.cloth_management.Models.Category;

import java.util.List;

public interface CategoryRepository {
    public boolean AddCategory(Category category);
    public boolean DeleteCategory(Category category);
    public boolean UpdateCategory(Category category);

    public List<Category> ListCategories();
    public Category GetCategory(int cat_id);
}
