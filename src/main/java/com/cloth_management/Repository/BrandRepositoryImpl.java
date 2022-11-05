package com.cloth_management.Repository;

import com.cloth_management.Models.Brand;
import com.cloth_management.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public class BrandRepositoryImpl implements BrandRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int AddBrand(Brand brand) {
        return jdbcTemplate.update("INSERT INTO brands(brand_name, brand_email) VALUES (?,?)",
                new Object[] {brand.getBrand_name(),brand.getBrand_email()});

    }

    @Override
    public int DeleteBrand(int brand_id) {
        return jdbcTemplate.update("DELETE FROM brands where brand_id=?",
                brand_id);
    }

    @Override
    public int UpdateBrand(Brand brand, int brand_id) {
        return jdbcTemplate.update("UPDATE brands SET brand_name=?,brand_email=? WHERE brand_id=?",
                new Object[]{brand.getBrand_name(),brand.getBrand_email(),brand_id});
    }

    @Override
    public List<Brand> ListBrand() {

        return jdbcTemplate.query("SELECT * FROM brands",
                new BeanPropertyRowMapper<Brand>(Brand.class));
    }

    @Override
    public Brand GetBrand(int brand_id) {
        return jdbcTemplate.queryForObject("SELECT * FROM brands where brand_id=?",
                new BeanPropertyRowMapper<Brand>(Brand.class),brand_id);
    }
}
