package com.farmfinder.commands;

import com.farmfinder.model.Category;
import com.farmfinder.mongo.ConnectionProvider;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import org.codehaus.jackson.map.ObjectMapper;

public class CreateCategory {

		public String execute(Category cat){
			ConnectionProvider conn = new ConnectionProvider() ;
			DBCollection coll = conn.getCollection("categories") ;
			ObjectMapper mpr = new ObjectMapper() ;
			
			try{
				DBObject catObject = (DBObject) JSON.parse(mpr.writeValueAsString(cat)) ;
				coll.insert(catObject) ;
				return catObject.get("_id").toString() ;
			}catch(Exception e){
				System.out.println("Error durring mapping Category to Mongo") ;
			}
			return null ; 
		}
}
