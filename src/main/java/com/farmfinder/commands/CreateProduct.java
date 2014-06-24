package com.farmfinder.commands;

import com.farmfinder.model.Product;
import com.farmfinder.mongo.ConnectionProvider;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import org.codehaus.jackson.map.ObjectMapper;

public class CreateProduct {
	public String execute(Product prd){
		ConnectionProvider conn = new ConnectionProvider() ;
		DBCollection coll = conn.getCollection("products") ;
		ObjectMapper mpr = new ObjectMapper() ;
		
		try{
			DBObject prdObject = (DBObject) JSON.parse(mpr.writeValueAsString(prd)) ;
			coll.insert(prdObject) ;
			return prdObject.get("_id").toString() ;
		}catch(Exception e){
			System.out.println("Error durring mapping Category to Mongo") ;
		}
		return null ; 
	}
}
