package com.edevement.startup.response;

import java.io.Serializable;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = 7354984441968523772L;
	private int userId;
	private String userType;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String phoneNumber;
	private String emailAddress;
	private String location;
	private String dob;
	private String status;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userType=" + userType + ", firstName=" + firstName + ", lastName="
				+ lastName + ", userName=" + userName + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + ", location=" + location + ", dob=" + dob + ", status=" + status
				+ "]";
	}
	
}
