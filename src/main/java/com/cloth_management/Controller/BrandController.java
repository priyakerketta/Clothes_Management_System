package com.cloth_management.Controller;

import com.cloth_management.Models.Brand;
import com.cloth_management.Models.Category;
import com.cloth_management.Repository.BrandRepository;
import com.cloth_management.Repository.CategoryRepository;
import com.cloth_management.service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;



@Controller
public class BrandController {

    @Autowired
    private SecurityServices securityServices;

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/admin/Brands")
    public String getBrand(Model model){

        List<Brand>  br=brandRepository.ListBrand();
        model.addAttribute("brands",br);
        return "Brands";

    }



//    @GetMapping("/brands/{brand_id}")
////    @Secured(hasRole("ADMIN"))
//    public Brand getBrandById(@PathVariable int brand_id){
//
//        return brandRepository.GetBrand(brand_id);
//    }
    @GetMapping("/add_brand")
    public String addBrand( Model model)
    {      List<Brand> br=brandRepository.ListBrand();
          model.addAttribute("brands",br);
          model.addAttribute("brand",new Brand());
        return "add_brand";
    }


    @PostMapping("/add_brand")
    public String addBrand(@ModelAttribute("brand") Brand brand, Model model, RedirectAttributes attributes)
    {
       int b= brandRepository.AddBrand(brand);
        return "redirect:/admin/Brands";
    }

    @PutMapping("brands/{brand_id}")
    public String updateBrand(@RequestBody Brand brand,@PathVariable int brand_id){
        return  brandRepository.UpdateBrand( brand, brand_id)+"No of rows affected";
    }

    @GetMapping("/admin/brand/delete/{brand_id}")
    public String deleteBrandById(@PathVariable int brand_id)
    {
        int br= brandRepository.DeleteBrand(brand_id);
        return "redirect:/admin/Brands";
    }

//    @DeleteMapping("/admin/brand/delete/{brand_id}")
//    public String deleteBrandById(@PathVariable int brand_id){
//        int br= brandRepository.DeleteBrand(brand_id);
//        return "redirect:/admin/Brands";
//    }
}
