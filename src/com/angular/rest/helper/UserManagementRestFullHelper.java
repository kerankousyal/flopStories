package com.angular.rest.helper;

import org.apache.commons.lang3.StringUtils;

import com.angular.rest.vo.UserRestVO;
import com.angular.vo.UserVO;

public class UserManagementRestFullHelper {
	
	public void prepareUserVO(UserRestVO userRestVO, UserVO userVO) {
		
		//null checks pending
		
		if(null!=userRestVO.username && StringUtils.isNotEmpty(userRestVO.username))
		userVO.setUsername(userRestVO.username);
		
		if(null!=userRestVO.password && StringUtils.isNotEmpty(userRestVO.password))
		userVO.setPassword(userRestVO.password);
		
		if(null!=userRestVO.securityQuestion && StringUtils.isNotEmpty(userRestVO.securityQuestion))
		userVO.setSecurityQuestion(userRestVO.securityQuestion);
		
		if(null!=userRestVO.firstname && StringUtils.isNotEmpty(userRestVO.firstname))
			userVO.setFirstname(userRestVO.firstname);
		
		if(null!=userRestVO.lastname && StringUtils.isNotEmpty(userRestVO.lastname))
			userVO.setLastname(userRestVO.lastname);
		
		if(null!=userRestVO.email && StringUtils.isNotEmpty(userRestVO.email))
			userVO.setEmail(userRestVO.email);
		
	}

}
