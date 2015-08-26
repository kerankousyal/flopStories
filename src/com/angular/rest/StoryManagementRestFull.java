package com.angular.rest;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.angular.rest.business.StoryManagementBusinessFacade;
import com.angular.rest.business.UserManagementBusinessFacade;
import com.angular.rest.helper.StoryManagementRestFullHelper;
import com.angular.rest.vo.StoryDetailRestVO;
import com.angular.rest.vo.UserRestVO;
import com.angular.vo.StoryDetail;
import com.angular.vo.UserVO;

@Path("/api/stories")
public class StoryManagementRestFull {
	
	@POST
	@Path("/savestory")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveStory(final StoryDetailRestVO storyRestVO)
			throws JsonParseException, JsonMappingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {

		
		StoryManagementBusinessFacade uFacade = new StoryManagementBusinessFacade();
		
		boolean result = uFacade.saveStory(storyRestVO);
		
		String response = "success";
		
		if(!result) 
			response = "save failed";
		
		return Response
				.ok()
				.entity(response)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}
	
	@GET
	@Path("/getallstories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStories()
			throws JsonParseException, JsonMappingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {

		StoryDetail uVO = new StoryDetail();
		
		
		StoryManagementBusinessFacade uFacade = new StoryManagementBusinessFacade();
		
		String result = uFacade.getAllStories();
		
		
		if(StringUtils.isEmpty(result) )
			result = "";
		
		return Response
				.ok()
				.entity(result)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}
	
	@GET
	@Path("/getstorydetail/{_id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getStoryDetail( @PathParam("_id") String _id)
			throws JsonParseException, JsonMappingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {

		
		StoryManagementBusinessFacade sFacade = new StoryManagementBusinessFacade();
		
		String result = "";
		
		result = sFacade.getStoryDetail(_id);
		
		
		if(StringUtils.isEmpty(result)) 
			result = "";
		
		
		return Response
				.ok()
				.entity(result)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}
	
	@POST
	@Path("/savecomments")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveComments(final StoryDetailRestVO storyRestVO)
			throws JsonParseException, JsonMappingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {

		StoryManagementBusinessFacade uFacade = new StoryManagementBusinessFacade();
		
		boolean result = uFacade.saveComments(storyRestVO);
		
		String response = "success";
		
		if(!result) 
			response = "save failed";
		
		return Response
				.ok()
				.entity(response)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}
}
