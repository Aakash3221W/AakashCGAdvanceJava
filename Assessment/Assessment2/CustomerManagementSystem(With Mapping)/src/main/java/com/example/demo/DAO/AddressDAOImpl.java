package com.example.demo.DAO;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Address;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
public class AddressDAOImpl implements AddressDAO {
    private EntityManager em;

    public AddressDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void saveAddress(Address address) {
        em.persist(address);
    }

    @Override
    public Address findAddressById(Long id) {
        return em.find(Address.class, id);
    }

    @Override
    @Transactional
    public void updateAddress(Address address) {
        em.merge(address);
    }
}
