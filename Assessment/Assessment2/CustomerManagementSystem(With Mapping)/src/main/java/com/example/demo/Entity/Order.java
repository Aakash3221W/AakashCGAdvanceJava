package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders") // 'Order' is a reserved keyword in SQL
public class Order {
    @Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", customer="
				+ customer + "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long orderId;
    
    @Column(name = "orderDate")
    private String orderDate;
    
    @Column(name = "totalAmount")
    private double totalAmount;
    

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

    public Order() {}
    public Order(String orderDate, double totalAmount) {
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
	}

    // Getters and Setters
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
