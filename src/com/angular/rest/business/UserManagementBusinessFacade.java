package com.angular.rest.business;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.angular.dao.UserManagementDAO;
import com.angular.helper.EncryptPassword;
import com.angular.vo.CurrentUserSession;
import com.angular.vo.UserVO;

public class UserManagementBusinessFacade {

	public String validateLogin(UserVO uVO) throws NoSuchAlgorithmException, InvalidKeySpecException, JsonGenerationException, JsonMappingException, IOException {
		
		String resultString ="";
		CurrentUserSession cUser = new CurrentUserSession();
		UserManagementDAO uDAO = new UserManagementDAO();
		
		if(null!=uVO.getUsername() || StringUtils.isNotEmpty(uVO.getUsername()) && null!=uVO.getPassword() || StringUtils.isNotEmpty(uVO.getPassword())) {
			
			cUser = uDAO.validateUser(uVO.getUsername(), uVO.getPassword());
			
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			
			resultString = ow.writeValueAsString(cUser);
		}
		
		return resultString;
	}

	public boolean registerUser(UserVO uVO) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		UserManagementDAO uDAO = new UserManagementDAO();
		
		boolean success = false;
		
		if(null!=uVO.getUsername() || StringUtils.isNotEmpty(uVO.getUsername()) && null!=uVO.getPassword() || StringUtils.isNotEmpty(uVO.getPassword())) {
			
			//encrypt password
			String encryptedPwd = EncryptPassword.encryptPassword(uVO.getPassword());
			
			success = uDAO.registerUser(uVO, encryptedPwd);
		}
		
		return success;
		
	}

	public boolean checkForDuplicateUser(UserVO uVO) {

UserManagementDAO uDAO = new UserManagementDAO();
		
		boolean success = false;
		
		if(null!=uVO.getUsername() || StringUtils.isNotEmpty(uVO.getUsername())) {
			
			
			success = uDAO.checkForDuplicateUser(uVO.getUsername());
		}

		return success;
	}

	public String getUserDetail(UserVO uVO) {

		
UserManagementDAO uDAO = new UserManagementDAO();
		
		String userList = "";
		
		if(null!=uVO.getUsername() || StringUtils.isNotEmpty(uVO.getUsername())) {
			
			
			userList = uDAO.getUserDetail(uVO.getUsername());
		}

		return userList;
	}
	
	

}
