package com.coders.DressStore.Entity;

public class PaymentInfo {

	private String token;
	private double amount;
	
	public PaymentInfo() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
