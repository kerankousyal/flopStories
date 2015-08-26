package com.angular.vo;

import java.util.Arrays;
import java.util.List;

public class StoryDetail {
	
	private String storyName;
	private String shortDescription;
	private String storyContent;
	private List<StoryCommentsVO> comments;
	private String ownerName;
	private String ownerRank;
	private String createdDate;
	private String modifiedDate;
	private String tags;
	private String category;
	private String status;
	private String _id;
	public String getStoryName() {
		return storyName;
	}
	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getStoryContent() {
		return storyContent;
	}
	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}
	public List<StoryCommentsVO> getComments() {
		return comments;
	}
	public void setComments(List<StoryCommentsVO> comments) {
		this.comments = comments;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerRank() {
		return ownerRank;
	}
	public void setOwnerRank(String ownerRank) {
		this.ownerRank = ownerRank;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	@Override
	public String toString() {
		return "StoryDetail [storyName=" + storyName + ", shortDescription="
				+ shortDescription + ", storyContent=" + storyContent
				+ ", comments=" + comments + ", ownerName=" + ownerName
				+ ", ownerRank=" + ownerRank + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", tags=" + tags
				+ ", category=" + category + ", status=" + status + ", _id="
				+ _id + "]";
	}
	
	
	
	

}
