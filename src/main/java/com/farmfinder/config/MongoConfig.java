package com.farmfinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories("com.farmfinder.commands")
public class MongoConfig extends AbstractMongoConfiguration
{
	//@Value("${mongodbName}")
	private String  dbName ="FarmFinder";
	
	//@Value("${mongodbURL}")
	private String  host = "oceanic.mongohq.com";
	
	//@Value("${mongodbPORT}")
	private Integer port = 10030;
	
	//@Value("${mongodbUser}")
	private String  userName = "farmfinder";
	
	//@Value("${mongodpd}")
	private String  password = "farmfinder123";
	
	
	@Override
	protected String getDatabaseName()
	{
	    return this.dbName;
	}
	
	@Override
	public Mongo mongo() throws Exception
	{
	    return new MongoClient(this.host, this.port);
	}
	
	@Override
	@Bean
	public SimpleMongoDbFactory mongoDbFactory() throws Exception
	{
	    return new SimpleMongoDbFactory(mongo(), getDatabaseName());
	}
	
	@Override
	@Bean
	public MongoTemplate mongoTemplate() throws Exception
	{
	    final UserCredentials userCredentials = new UserCredentials(this.userName, this.password);
	
	    final MongoTemplate mongoTemplate = new MongoTemplate(mongo(), getDatabaseName(), userCredentials);
	    mongoTemplate.setWriteConcern(WriteConcern.SAFE);
	
	    return mongoTemplate;
	}
	
	public static void main(String[] args){
		MongoConfig config = new MongoConfig() ;
		System.out.println(config.getDatabaseName()) ;
	}

}

