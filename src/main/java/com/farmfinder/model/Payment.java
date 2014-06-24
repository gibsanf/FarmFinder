package com.farmfinder.model;

import java.util.Date;

public class Payment {
	
	private int productID;
	private int orderID;
	private int catagoryID;
	private String productName;
	private int quantity;
	private int totalPrice;
	private int unitPrice;
	
	// payment info
		private String paymentMethod;
		private String nameonCard;
		private String cardNumber;
		private Date expirDate;
		private int securityCode;
		
		
		// billing  info
		private String address;
		private String state;
		private String city;
		private String country;
		private int zipcode;
		
	    // setter and getters

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCatagoryID() {
		return catagoryID;
	}

	public void setCatagoryID(int catagoryID) {
		this.catagoryID = catagoryID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

}
