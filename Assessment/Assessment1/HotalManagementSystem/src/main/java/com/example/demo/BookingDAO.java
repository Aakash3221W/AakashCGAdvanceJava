package com.example.demo;

import java.util.List;

public interface BookingDAO {
    void save(Booking booking);          
    List<Booking> findAll();             
    void update(Booking booking);        
    void deleteById(int id);
	Booking findById(int id);         
}
