package com.farmfinder.services;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.farmfinder.commands.CategoryRepo;
import com.farmfinder.config.MongoConfig;
import com.farmfinder.model.Category;

@Path("/farmfinder")
public class FarmFinder {
	@POST
	@Path("/createFarm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createFarm(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		CategoryRepo repo = (CategoryRepo) ctx.getBean(CategoryRepo.class) ;
		/*Create new category class*/ 
		Category cat = new Category() ;
		cat.setName("Strawberry") ;		
		repo.save(cat) ;
		return Response.status(201).entity(cat).build() ;
	}
}
