package com.farmfinder.services;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.farmfinder.commands.CategoryRepo;
import com.farmfinder.commands.ProductRepo;
import com.farmfinder.config.MongoConfig;
import com.farmfinder.model.Cart;
import com.farmfinder.model.Category;
import com.farmfinder.model.Product;

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
	
	@PUT
	@Path("/addtoCart")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addtoCart(@Context HttpServletRequest request , String cartData ){
		
		String [] products = request.getParameterValues("product") ;
		String quantity = request.getParameter("products");
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		ProductRepo repo = (ProductRepo) ctx.getBean(ProductRepo.class) ;
		Product product = repo.findOne(products[0]);
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("name", product.getName());
		map.put("price", Double.toString(product.getPrice()));
		map.put("quantity", quantity);
		HttpSession session = request.getSession();
		
		Cart cart = (Cart) session.getAttribute("cartSession");
		
		if(cart==null){
			
			
		}
		return null;
		
	}
	
	
	
}
