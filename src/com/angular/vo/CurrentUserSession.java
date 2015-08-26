package com.angular.vo;

public class CurrentUserSession {

	private String status;
	private UserVO user;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "CurrentUserSession [status=" + status + ", user=" + user + "]";
	}
	
	
}
