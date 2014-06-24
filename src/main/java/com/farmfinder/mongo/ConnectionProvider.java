package com.farmfinder.mongo;
/*
 *  This class provides access to the collections created on mongohq.com, provided that 
 *  credientials are valid.
 */
import java.net.UnknownHostException;

 import com.mongodb.DB ;
 import com.mongodb.DBCollection ;
 import com.mongodb.MongoClient ;
 import com.mongodb.MongoException ;
 import com.farmfinder.properties.*;
 
public class ConnectionProvider {
	public DBCollection getCollection(String Collection){
		try{
			PropertiesLookup lookup = new PropertiesLookup() ;
			String url = lookup.getProperty("mongodbURL") ;
			String port = lookup.getProperty("mongodbPORT") ;
			String user = lookup.getProperty("mongodbUser") ;
			String pass = lookup.getProperty("mongodbPd") ;
			MongoClient mongo = new MongoClient(url,Integer.parseInt(port)) ;
			
			DB db = mongo.getDB("FarmFinder") ;
			if ( db == null ) {
				System.out.println("Error connecting to FarmFinder database") ;
			}
			
			boolean auth = db.authenticate(user, pass.toCharArray()) ;
			if(auth == false){
				System.out.println("Authentication failed!") ;
			}
			
			/*For now, collection Farms does not exist! Just a place holder!*/
			DBCollection farmCollection = db.getCollection(Collection);
			
			return farmCollection ;
		} 
		catch (UnknownHostException e){
			e.printStackTrace() ;
		}
		catch (MongoException e){
			e.printStackTrace() ;
		}
		return null ;
	}
	
	/*Test getCollection()*/
	public static void main (String[] args){
		ConnectionProvider connection = new ConnectionProvider() ;
		DBCollection FarmsCollection = connection.getCollection("farms") ;
		if (FarmsCollection == null){
			System.out.println("Error: Unable to get collection Farms!") ;
		}else{
			System.out.println("Sucess: Able to get Collection Farms!") ;
		}
		
	}
}
