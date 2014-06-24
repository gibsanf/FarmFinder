package com.farmfinder.model;

import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonIgnore;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * @author Group: FarmFinder
 * 
 */

public class Category {
	private String type ;
	private String name ;
	@JsonDeserialize(as=ArrayList.class, contentAs=String.class) private ArrayList<String> FarmID ;
	
	/*******************Setters and Getters***********************/
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonIgnore
	public ArrayList<String> getFarmID() {
		return FarmID;
	}
	public void setFarmID(ArrayList<String> farmID) {
		FarmID = farmID;
	}
}
