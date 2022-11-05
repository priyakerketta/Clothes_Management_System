package com.cloth_management.Controller;

import com.cloth_management.Models.Category;
import com.cloth_management.Repository.CategoryRepository;
import com.cloth_management.service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private SecurityServices securityServices;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public List<Category> getCategories(){

        return categoryRepository.ListCategories();
    }
//    @GetMapping("/shop")
//    public List<Category> getCategoriesList(){
//
//        return categoryRepository.ListCategories();
//    }


    @GetMapping("/category/{cat_id}")
    public Category getCategoryById(@PathVariable int cat_id){

        return categoryRepository.GetCategory(cat_id);
    }

    @PostMapping("/add_category")
    public String addCategory(@RequestBody Category category){
        return categoryRepository.AddCategory(category) + "No of Rows Affected";

    }

    @PutMapping("category/{cat_id}")
    public String updateCategory(@RequestBody Category category,@PathVariable int cat_id){
      return categoryRepository.UpdateCategory(category,cat_id)+"No of rows affected";
    }

    @DeleteMapping("/category/{cat_id}")
    public String deleteCategoryById(@PathVariable int cat_id){
        return categoryRepository.DeleteCategory(cat_id)+"No of rows affected";
    }

}
