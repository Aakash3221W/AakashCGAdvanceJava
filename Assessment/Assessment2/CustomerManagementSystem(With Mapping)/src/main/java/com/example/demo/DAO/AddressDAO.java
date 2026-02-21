package com.example.demo.DAO;

import com.example.demo.Entity.Address;

public interface AddressDAO {
    void saveAddress(Address address);
    Address findAddressById(Long id);
    void updateAddress(Address address);
}
