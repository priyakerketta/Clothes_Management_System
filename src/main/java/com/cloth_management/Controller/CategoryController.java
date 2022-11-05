package com.cloth_management.Controller;

import com.cloth_management.Models.Brand;
import com.cloth_management.Models.Category;
import com.cloth_management.Repository.CategoryRepository;
import com.cloth_management.service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private SecurityServices securityServices;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/admin/category")
    public String  getCategories(Model model){
        List<Category>  cat=categoryRepository.ListCategories();
        model.addAttribute("categories",cat);
        return "category";

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

    @GetMapping("/add_category")
    public String addCategory( Model model)
    {      List<Category> cat=categoryRepository.ListCategories();
        model.addAttribute("categories",cat);
        model.addAttribute("category",new Category());
        return "add_category";
    }


    @PostMapping("/add_category")
    public String addCategory(@ModelAttribute("category") Category category, Model model, RedirectAttributes attributes)
    {
        int c= categoryRepository.AddCategory(category);
        return "redirect:/admin/category";
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
