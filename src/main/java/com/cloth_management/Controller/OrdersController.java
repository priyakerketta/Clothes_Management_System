package com.cloth_management.Controller;

import com.cloth_management.Models.Category;
import com.cloth_management.Models.Order;
import com.cloth_management.Repository.OrderRepository;
import com.cloth_management.service.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private SecurityServices securityServices;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/admin/Orders")
    public String getOrders(Model model){
        List<Order> ord = orderRepository.findAllOrders();
        model.addAttribute("orders", ord);
        return "Orders";
    }


}
