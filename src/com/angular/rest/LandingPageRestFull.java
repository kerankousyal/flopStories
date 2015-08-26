package com.angular.rest;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.angular.dao.LandingPageDAO;

@Path("/api/landingpage")
public class LandingPageRestFull {
	
	@GET
	@Path("/getTopUsers/{limit}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getTopUsers(@PathParam("limit") int limit)
			throws JsonParseException, JsonMappingException, IOException {

		LandingPageDAO lDAO = new LandingPageDAO();
		String resultString ="";
		resultString = lDAO.getAllTopPlayers(limit);
		
		return Response
				.ok()
				.entity(resultString)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}
	
	@GET
	@Path("/getFeaturedStory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFeaturedStory()
			throws JsonParseException, JsonMappingException, IOException {

		LandingPageDAO lDAO = new LandingPageDAO();
		String resultString ="";
		resultString = lDAO.getFeaturedStory();
		
		return Response
				.ok()
				.entity(resultString)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}

}
