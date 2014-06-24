package com.farmfinder.commands;

import org.codehaus.jackson.map.ObjectMapper;

import com.farmfinder.model.Farm;

import com.farmfinder.mongo.ConnectionProvider;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class CreateFarm {
	public String execute(Farm frm){
		ConnectionProvider conn = new ConnectionProvider() ;
		DBCollection coll = conn.getCollection("categories") ;
		ObjectMapper mpr = new ObjectMapper() ;
		
		try{
			DBObject frmObject = (DBObject) JSON.parse(mpr.writeValueAsString(frm)) ;
			coll.insert(frmObject) ;
			return frmObject.get("_id").toString() ;
		}catch(Exception e){
			System.out.println("Error durring mapping Category to Mongo") ;
		}
		return null ; 
	}
}
