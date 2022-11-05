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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private SecurityServices securityServices;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/admin/Products")
    public String getProduct(Model model){

        List<Product> pr = productRepository.ListProducts();
        model.addAttribute("products", pr);
        return "Products";
    }

    @GetMapping("/shop/view_product/{prod_id}")
    public String getViewProduct(@PathVariable(value = "prod_id") int prod_id, Model model){

        Product pr= productRepository.GetProductById(prod_id);
        model.addAttribute("product", pr);
        return "view_product";
    }

    @GetMapping("/shop/brand/{brand_id}")
    public  String getProductByBrand(@PathVariable(value = "brand_id") int brand_id, Model model)
    {
        List<Category> cat=categoryRepository.ListCategories();
        List<Brand> br = brandRepository.ListBrand();
//        List<Product> pr= productRepository.ListProducts();
        model.addAttribute("categories", cat);
        model.addAttribute("brands", br);
//        model.addAttribute("products",pr);
        List <Product> pr=productRepository.FilterByBrand(brand_id);
        model.addAttribute("product", pr);
        return "Shop";
    }

    @GetMapping("/add_products")
    public String addProd( Model model)
    {      List<Product> pr=productRepository.ListProducts();
        List<Category> cat=categoryRepository.ListCategories();
        List<Brand>   br=brandRepository.ListBrand();
        model.addAttribute("categories",cat);
        model.addAttribute("brands",br);
        model.addAttribute("products",pr);
        model.addAttribute("product",new Product());
        return "add_products";
    }


    @PostMapping("/add_products")
    public String addProduct(@ModelAttribute("product") Product product, Model model, RedirectAttributes attributes) {
        int p = productRepository.AddProduct(product);
        return "redirect:/admin/Products";
    }

    @GetMapping("/admin/product/delete/{prod_id}")
    public String deleteProductById(@PathVariable int prod_id)
    {
        int pr= productRepository.DeleteProduct(prod_id);
        return "redirect:/admin/Products";
    }

}
