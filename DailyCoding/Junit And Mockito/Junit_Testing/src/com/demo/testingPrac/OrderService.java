package com.demo.testingPrac;

public class OrderService {
	
	PaymentGateway paymentGateway;
	
	public OrderService(PaymentGateway paymentGateway) {
		this.paymentGateway = paymentGateway;
	}
	
	public boolean processOrder(Order order) {
		return paymentGateway.processPayment(order.getAmount());
	}
}
