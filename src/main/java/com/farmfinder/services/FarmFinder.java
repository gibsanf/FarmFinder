
package com.farmfinder.services;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

/* add products to cart  Gibsan Abdu*/
	
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
		 double totalp = 0;
		if(cart==null){
			cart = new Cart();
			cart.addtoList(map);
            totalp = Double.parseDouble(quantity) * product.getPrice(); 
		}else {
			totalp = cart.getTotalPrice() + Double.parseDouble(quantity) * product.getPrice(); 
			cart.addtoList(map);
		}
		cart.setTotalPrice(totalp);
		session.setAttribute("cartSession", cart);
		return Response.status(201).entity(cart).build();	
	}
/*.................................................................................... */
	
	
/*  List products stored in cart  GIBSAN ABDU */
	
	@GET
	@Path("/listallCart")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response listallCart(@Context HttpServletRequest request){
		
		HttpSession session = request.getSession(false);
		Cart cart = (Cart) session.getAttribute("cartSession");
		return Response.status(201).entity(cart).build();
	}
	
/*.................................................................................... */
	
	
/*  Delete single product stored in cart  GIBSAN ABDU */	
	
	@DELETE
	@Path("/deleteCart/{index}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response deleteCart(@Context HttpServletRequest request, @PathParam("index")String index){
	
		HttpSession session = request.getSession(false);
		Cart cart = (Cart) session.getAttribute("cartSession");
		List <HashMap> cartList = cart.getProdlst();
		cartList.remove(Integer.parseInt(index));
		return Response.status(201).entity(index).build();	
	}

/*.................................................................................... */
		
/*  Delete all product stored in cart / clear Cart GIBSAN ABDU */
	
	@DELETE
	@Path("/deleteAllCart/{index}")
	@Produces(MediaType.APPLICATION_JSON)	
	public Response deleteAllCart(@Context HttpServletRequest request, @PathParam("index")String index){
	
		HttpSession session = request.getSession(false);
		Cart cart = (Cart) session.getAttribute("cartSession");
		List <HashMap> cartList = cart.getProdlst();
		cartList.clear();
		return Response.status(201).entity(index).build();	
	}
}
