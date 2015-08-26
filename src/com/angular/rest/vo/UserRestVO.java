package com.angular.rest.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class UserRestVO {

	
	@XmlElement
	public String username;
	@XmlElement
	public String password;
	@XmlElement
	public String securityQuestion;
	@XmlElement
	public String firstname;
	@XmlElement
	public String lastname;
	@XmlElement
	public String email;
	
}
