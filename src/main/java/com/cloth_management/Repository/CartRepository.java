package com.cloth_management.Repository;


import com.cloth_management.Models.Cart;

import java.util.List;

public interface CartRepository {

    public int AddToCart(Cart cart);

    public int DeleteFromCart(int prod_id, int user_id);

    public int UpdateFromCart(Cart cart);

    public  int ClearCart(int user_id);

    public List<Cart> GetCart(int user_id);



}
