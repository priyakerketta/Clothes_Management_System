package com.cloth_management.Repository;

import com.cloth_management.Models.Employee;
import com.cloth_management.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public class ProductRepositoryImpl implements ProductRepository {
      @Autowired
      JdbcTemplate jdbcTemplate;

    @Override
    public int AddProduct(Product product) {
        return jdbcTemplate.update("INSERT INTO products (prod_title,prod_description,prod_colour,"+
                "cat_id,brand_id,price,size,quantity,image_path) VALUES (?,?,?,?,?,?,?,?,?)",
                new Object[] {product.getProd_title(),product.getProd_description(),product.getProd_colour(),
                        product.getCat_id(),product.getBrand_id(),product.getPrice(),product.getSize(),product.getQuantity()
                        ,product.getImage_path()});
    }

    @Override
    public int DeleteProduct(int prod_id) {
        return jdbcTemplate.update("DELETE FROM products where prod_id=?",prod_id);
    }

    @Override
    public int UpdateProduct(Product product, int prod_id) {
        return jdbcTemplate.update("UPDATE products SET prod_title=?,prod_description=?,prod_colour=?"+
                ",cat_id=?,brand_id=?,price=?,size=?, quantity=?, image_path=? WHERE prod_id=?",
                new Object[]{product.getProd_title(),product.getProd_description(),product.getProd_colour(),
                        product.getCat_id(),product.getBrand_id(),product.getPrice(),product.getSize(),product.getQuantity(),
                        product.getImage_path()},prod_id);
    }

    @Override
    public List<Product> ListProducts() {
        return jdbcTemplate.query("SELECT * FROM products",new BeanPropertyRowMapper<Product>(Product.class));
    }

    @Override
    public Product GetProductById(int prod_id) {
        return jdbcTemplate.queryForObject("SELECT * FROM products where prod_id=?",
                new BeanPropertyRowMapper<Product>(Product.class),prod_id);
    }

    @Override
    public Product GetProductByTitle(String prod_title) {

        try {
            return jdbcTemplate.queryForObject("SELECT * FROM products where prod_title=?",
                    new BeanPropertyRowMapper<Product>(Product.class), prod_title);
        }catch (EmptyResultDataAccessException e){ return null;}
    }

//    @Override
//    public List<Product> FilterByBrand(String brand_name) {
////        return jdbcTemplate.query("SELECT * FROM products WHERE brand_id=(SELECT brand_id FROM brands WHERE brand_name=?)",
//        return jdbcTemplate.query("SELECT * FROM products WHERE brand_id=?",
//                new BeanPropertyRowMapper<Product>(Product.class),brand_name);
//
//    }
    @Override
    public List<Product> FilterByBrand(int brand_id) {
        return jdbcTemplate.query("SELECT * FROM products WHERE brand_id=?",
                new BeanPropertyRowMapper<Product>(Product.class),brand_id);

    }

    @Override
    public List<Product> FilterByCategory(String cat_name) {
     return jdbcTemplate.query("SELECT * FROM products WHERE cat_id=(SELECT cat_id FROM categories WHERE cat_name=?)",
             new BeanPropertyRowMapper<Product>(Product.class),cat_name);
    }
}
