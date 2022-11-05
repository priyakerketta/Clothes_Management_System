package com.cloth_management.Repository;

import com.cloth_management.Models.Product;

import java.util.List;

public interface ProductRepository {

    public int AddProduct(Product product);

    public int DeleteProduct(int prod_id);

    public int UpdateProduct(Product product, int prod_id);

    public List<Product> ListProducts();

    public Product GetProductById(int prod_id);
    public Product GetProductByTitle(String prod_title);
    public List<Product> FilterByCategory(String cat_name);
//    public List<Product> FilterByBrand(String brand_name);

    public List<Product> FilterByBrand(int brand_id);
}