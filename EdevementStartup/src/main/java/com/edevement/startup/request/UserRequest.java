package com.edevement.startup.request;

import java.io.Serializable;

public class UserRequest implements Serializable {

	private static final long serialVersionUID = -5387502986756542891L;
	private String userName;
	private String userType;
	private String password;
	private String status;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "UserRequest [userName=" + userName + ", userType=" + userType + ", password=" + password + ", status="
				+ status + "]";
	}
	
}
