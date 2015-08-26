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

import com.angular.rest.business.UserManagementBusinessFacade;
import com.angular.rest.helper.UserManagementRestFullHelper;
import com.angular.rest.vo.UserRestVO;
import com.angular.vo.UserVO;

@Path("/api")
public class UserManagementRestfull {
	
	@POST
	@Path("/authenticate")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response validateLogin(final UserRestVO userRestVO)
			throws JsonParseException, JsonMappingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		
		UserVO uVO = new UserVO();
		
		UserManagementRestFullHelper helper = new UserManagementRestFullHelper();
		helper.prepareUserVO(userRestVO, uVO);
		
		UserManagementBusinessFacade uFacade = new UserManagementBusinessFacade();
		
		String result = "success";
		result = uFacade.validateLogin(uVO);
		
		return Response
				.ok()
				.entity(result)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"POST, GET, PUT, UPDATE, OPTIONS")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}
	
	@POST
	@Path("/register")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUser(final UserRestVO userRestVO)
			throws JsonParseException, JsonMappingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {

		UserVO uVO = new UserVO();
		
		UserManagementRestFullHelper helper = new UserManagementRestFullHelper();
		helper.prepareUserVO(userRestVO, uVO);
		
		UserManagementBusinessFacade uFacade = new UserManagementBusinessFacade();
		
		boolean result = uFacade.registerUser(uVO);
		
		String response = "success";
		
		if(!result) 
			response = "registration failed";
		
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
	@Path("/duplicateuser/{username}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response duplicateUserCheck( @PathParam("username") String username)
			throws JsonParseException, JsonMappingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {

		System.out.println("ducplicate check for "+username);
		UserVO uVO = new UserVO();
		
		uVO.setUsername(username);
		
		UserManagementBusinessFacade uFacade = new UserManagementBusinessFacade();
		
		boolean result = uFacade.checkForDuplicateUser(uVO);
		
		String response = "success";
		
		if(!result) 
			response = "user already exists";
		
		System.out.println(response);
		
		return Response
				.ok()
				.entity(response)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET")
				.header("Access-Control-Allow-Headers",
						"Content-Type, Accept, X-Requested-With").build();
	}
	
	@GET
	@Path("/getuserdetail/{username}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUserDetail( @PathParam("username") String username)
			throws JsonParseException, JsonMappingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException {

		UserVO uVO = new UserVO();
		
		uVO.setUsername(username);
		
		UserManagementBusinessFacade uFacade = new UserManagementBusinessFacade();
		
		String result = "";
		
		result = uFacade.getUserDetail(uVO);
		
		
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

}
