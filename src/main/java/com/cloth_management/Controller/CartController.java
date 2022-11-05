package com.cloth_management.Controller;

import com.cloth_management.Models.Cart;
import com.cloth_management.Models.Product;
import com.cloth_management.Repository.CartRepository;
import com.cloth_management.Repository.ProductRepository;
import com.cloth_management.service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {

    @Autowired
    private SecurityServices securityServices;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/cart/{user_id}")
    public String getCart(@PathVariable(value = "user_id") int user_id, Model model){
        List<Cart> cart = cartRepository.GetCart(user_id);
        Map<Object, Object> cartProducts = new HashMap<Object,Object>();
        int cart_total = 0;
        for (Cart cartProduct : cart) {
            Product product = productRepository.GetProductById(cartProduct.getProd_id());
            cartProducts.put(cartProduct, product);
            cart_total += product.getPrice() * cartProduct.getProd_quantity();
        }

        model.addAttribute("cart", cart);
        model.addAttribute("cartProduct", cartProducts);
        model.addAttribute("cart_total",cart_total);
        return "cart";
    }
}
