package com.cloth_management.Repository;

import com.cloth_management.Models.Order;

import java.util.List;

public interface OrderRepository {


    public int addOrder(Order order);

    public int updateOrder(Order order, int order_id);

    public List<Order> findAllOrders();

    public List<Order> getOrdersByUser(int user_id);
}

