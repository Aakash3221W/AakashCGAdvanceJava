package com.example.demo.DAO;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;



@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private EntityManager em;

    public CustomerDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        em.persist(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return em.find(Customer.class, id);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        em.merge(customer);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        Customer customer = findCustomerById(id);
        if (customer != null) {
            em.remove(customer);
        }
    }
    
}
