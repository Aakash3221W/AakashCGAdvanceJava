package com.example.demo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO {

    private EntityManager entityManager;

    @Autowired
    public BookingDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Booking booking) {
        calculateAndSetAmount(booking); 
        entityManager.persist(booking);
    }

    @Override
    public List<Booking> findAll() {
        TypedQuery<Booking> query = entityManager.createQuery("FROM Booking", Booking.class);
        return query.getResultList();
    }
    @Override
    public Booking findById(int id) {
		return entityManager.find(Booking.class, id);
	}
    @Override
    @Transactional
    public void update(Booking booking) {
        Booking existingBooking = entityManager.find(Booking.class, booking.getBookingId());
        
        if (existingBooking != null) {
            existingBooking.setRoomType(booking.getRoomType());
            calculateAndSetAmount(existingBooking); 
            entityManager.merge(existingBooking);
        } else {
            System.out.println("Error: Booking ID " + booking.getBookingId() + " not found.");
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Booking booking = entityManager.find(Booking.class, id);
        if (booking != null) {
            entityManager.remove(booking);
        }
    }


    private void calculateAndSetAmount(Booking b) {
        try {
            LocalDate checkIn = LocalDate.parse(b.getCheckInDate());
            LocalDate checkOut = LocalDate.parse(b.getCheckOutDate());

            if (checkIn.isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("Check-in date cannot be in the past.");
            }
            if (!checkOut.isAfter(checkIn)) {
                throw new IllegalArgumentException("Check-out date must be after check-in date.");
            }

            long days = ChronoUnit.DAYS.between(checkIn, checkOut);

            int pricePerDay = switch (b.getRoomType().trim()) {
                case "standard" -> 2000; 
                case "deluxe" -> 3500;   
                case "suite" -> 5000;   
                default -> throw new IllegalArgumentException("Invalid Room Type: " + b.getRoomType());
            };

            b.setTotalAmount(days * pricePerDay); 

        } catch (java.time.format.DateTimeParseException e) {
            throw new RuntimeException("Invalid date format. Please use YYYY-MM-DD.");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Booking Error: " + e.getMessage());
        }
    }
}