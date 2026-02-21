package com.example.demo.DAO;

import com.example.demo.Entity.Customer;


public interface CustomerDAO {
    void saveCustomer(Customer customer);
    Customer findCustomerById(Long id);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}