package com.example.demo.DAO;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class OrderDAOImpl implements OrderDAO {
    private EntityManager em;

    public OrderDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        em.persist(order);
    }

    @Override
    public Order findOrderById(Long id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> findOrdersByCustomerId(Long customerId) {
        String jpql = "SELECT o FROM Order o WHERE o.customer.customerId = :custId";
        TypedQuery<Order> query = em.createQuery(jpql, Order.class);
        query.setParameter("custId", customerId);
        return query.getResultList();
    }
}
