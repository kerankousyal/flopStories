package com.angular.rest.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StoryCommentsRestVO {

	@XmlElement
	public String comments;
	@XmlElement
	public String commentedUser;
}
