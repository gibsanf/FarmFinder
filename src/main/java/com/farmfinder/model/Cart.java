/*  Created by Gibsan Abdu */

package com.farmfinder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Cart {
	
	// product info
	//private int productID;
	//private int orderID;
	//private int catagoryID;
	//private String productName;
	//private int quantity;
	private double totalPrice;
	//private int unitPrice;
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<HashMap> getProdlst() {
		return prodlst;
	}

	public void setProdlst(List<HashMap> prodlst) {
		this.prodlst = prodlst;
	}

   public void addtoList(HashMap<String, String> map){
	   prodlst.add(map);
   }

	List <HashMap> prodlst = new ArrayList<HashMap>();  
     
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
