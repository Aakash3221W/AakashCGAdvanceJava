package com.example.common.models;

public class Cars {
	private String id;
	private String model;
	private double pricePerDay;
	
	public Cars() {
		super();
	}
	public Cars(String id, String model, double pricePerDay) {
		super();
		this.id = id;
		this.model = model;
		this.pricePerDay = pricePerDay;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPricePerDay() {
		return pricePerDay;
	}
	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
	
	
}
