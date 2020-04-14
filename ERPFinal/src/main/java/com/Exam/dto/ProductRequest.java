package com.Exam.dto;

public class ProductRequest {
	 int id;
	 String name;
	 double price;
	 int amount;
	 int sum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public ProductRequest(int id, String name, double price, int amount, int sum) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.sum = sum;
	}
	public ProductRequest() {
		super();
	}
	
}
