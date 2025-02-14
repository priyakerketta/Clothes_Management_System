package com.cloth_management.Controller;

import com.cloth_management.Models.Brand;
import com.cloth_management.Models.Category;
import com.cloth_management.Models.Product;
import com.cloth_management.Repository.BrandRepository;
import com.cloth_management.Repository.CategoryRepository;
import com.cloth_management.Repository.ProductRepository;
import com.cloth_management.service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShopController {

    @Autowired
    private SecurityServices securityServices;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String gethome()
    {
        return "home";
    }

    @GetMapping("/shop")
    public String getShopList(Model model){
        model.addAttribute("username",securityServices.findLoggedInUsername());
        List<Category> cat=categoryRepository.ListCategories();
        List<Brand> br = brandRepository.ListBrand();
        List<Product> pr= productRepository.ListProducts();
        model.addAttribute("categories", cat);
        model.addAttribute("brands", br);
        model.addAttribute("products",pr);
        return "Shop";


    }
}




