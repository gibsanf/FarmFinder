package com.farmfinder.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.farmfinder.model.Category ;

/**
 * @author Group: FarmFinder
 * 
 */

public class Product {
	private String FarmID ;
	private String name ;
	private double price ;
	private Category category ;
	
	/*******************Setters and Getters***********************/
	@JsonIgnore
	public String getFarmID() {
		return FarmID;
	}
	public void setFarmID(String farmID) {
		FarmID = farmID;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
