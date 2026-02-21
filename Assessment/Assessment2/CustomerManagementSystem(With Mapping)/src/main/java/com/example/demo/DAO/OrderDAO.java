package com.example.demo.DAO;

import java.util.List;

import com.example.demo.Entity.Order;

public interface OrderDAO {
    void saveOrder(Order order);
    Order findOrderById(Long id);
    List<Order> findOrdersByCustomerId(Long customerId);
}
