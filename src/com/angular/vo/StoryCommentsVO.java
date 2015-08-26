package com.angular.vo;

public class StoryCommentsVO {

	private String comments;
	private  String commentedUser;
	private String commentedDate;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCommentedUser() {
		return commentedUser;
	}
	public void setCommentedUser(String commentedUser) {
		this.commentedUser = commentedUser;
	}
	public String getCommentedDate() {
		return commentedDate;
	}
	public void setCommentedDate(String commentedDate) {
		this.commentedDate = commentedDate;
	}
	@Override
	public String toString() {
		return "StoryCommentsVO [comments=" + comments + ", commentedUser="
				+ commentedUser + ", commentedDate=" + commentedDate + "]";
	}
	
	
	
	
	
	
}
