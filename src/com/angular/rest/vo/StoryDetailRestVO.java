package com.angular.rest.vo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.angular.vo.StoryCommentsVO;

@XmlRootElement
public class StoryDetailRestVO {
	
	@XmlElement
	public String storyName;
	@XmlElement
	public String shortDescription;
	@XmlElement
	public String storyContent;
	@XmlElement
	public StoryCommentsVO[] comments;
	@XmlElement
	public String ownerName; //userid
	@XmlElement
	public String createdDate;
	@XmlElement
	public String modifiedDate;
	@XmlElement
	public String tags;
	@XmlElement
	public String category;
	@XmlElement
	public String status;
	@XmlElement
	public String _id;

}
