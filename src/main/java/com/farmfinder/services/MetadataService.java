package com.farmfinder.services;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.farmfinder.model.* ;

@Path("/metadata")
public class MetadataService {
	ObjectMapper mapper = new ObjectMapper();
	
	@GET
	@Path("/farm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFarmMetadata() {
		Farm farm = new Farm();
		String farmJSON;
		try {
			/*returns json object of a book */
			farmJSON = mapper.writeValueAsString(farm);
			return Response.status(200).entity(farmJSON).build();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}

	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoryMetadata() {
		Category cat = new Category();
		String catJSON;
		try {
			/*returns json object of a book */
			catJSON = mapper.writeValueAsString(cat);
			return Response.status(200).entity(catJSON).build();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@GET
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductMetadata() {
		Product prd = new Product();
		String prdJSON;
		try {
			/*returns json object of a book */
			prdJSON = mapper.writeValueAsString(prd);
			return Response.status(200).entity(prdJSON).build();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
}


