package com.cloth_management.Repository;

import com.cloth_management.Models.Cart;
import com.cloth_management.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepositoryImpl implements CartRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int AddToCart(Cart cart) {

        try{
            return jdbcTemplate.update("INSERT INTO cart_details (user_id, prod_id,  prod_quantity) VALUES(?,?,?)"
                    , cart.getUser_id(), cart.getProd_id(),  cart.getProd_quantity() ) ;
        }
        catch (Exception e)
        {
            return UpdateFromCart(cart);
        }
    }

    @Override
    public int DeleteFromCart(int prod_id, int user_id) {
        return jdbcTemplate.update("DELETE FROM cart_details WHERE prod_id = ? AND user_id = ?", prod_id, user_id) ;
    }

    @Override
    public int UpdateFromCart(Cart cart) {
        try {
            return jdbcTemplate.update("UPDATE cart_details SET prod_quantity = ? WHERE user_id = ? AND prod_id = ?",
                    cart.getProd_quantity(),cart.getUser_id(),cart.getProd_id());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int ClearCart(int user_id) {
        return jdbcTemplate.update("DELETE FROM cart_details WHERE user_id=?", user_id);
    }

    @Override
    public List<Cart> GetCart(int user_id) {

        return jdbcTemplate.query("SELECT * FROM cart_details WHERE user_id=?"
                ,new BeanPropertyRowMapper<Cart>(Cart.class),user_id);

    }



}
