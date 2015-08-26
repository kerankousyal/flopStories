package com.angular.vo;

import java.io.Serializable;
import java.util.ArrayList;



public class UserVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String securityQuestion;
	private String firstname;
	private String lastname;
	private String createdDate;
	private String modifiedDate;
	private ArrayList<StoryDetail> storyList;
	private String rank;
	private String imageURL;
	private String imageType;
	private String role;
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public ArrayList<StoryDetail> getStoryList() {
		return storyList;
	}
	public void setStoryList(ArrayList<StoryDetail> storyList) {
		this.storyList = storyList;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserVO [username=" + username + ", password=" + password
				+ ", securityQuestion=" + securityQuestion + ", firstname="
				+ firstname + ", lastname=" + lastname + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate
				+ ", storyList=" + storyList + ", rank=" + rank + ", imageURL="
				+ imageURL + ", imageType=" + imageType + ", role=" + role
				+ ", email=" + email + "]";
	}
	

}
