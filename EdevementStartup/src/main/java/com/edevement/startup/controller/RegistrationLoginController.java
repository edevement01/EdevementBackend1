package com.edevement.startup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edevement.startup.model.User;
import com.edevement.startup.request.AddUserRequest;
import com.edevement.startup.request.UserRequest;
import com.edevement.startup.response.Status;
import com.edevement.startup.service.RegistrationLoginService;



@CrossOrigin(maxAge = 3600)
@RestController
public class RegistrationLoginController {
	
	@Autowired
	private RegistrationLoginService registrationLoginService;
	
	@PostMapping("addUser")
	public ResponseEntity<Status> addUser( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody AddUserRequest addUserRequest) {
		System.out.println("addUser");
		Status message = new Status();
		message.setStatusCode(HttpStatus.BAD_REQUEST.value());
		message.setStatusMessage("Error occured while adding the product.");
		try {
			User registeredUser = registrationLoginService.findByUserNameOrEmailAddressOrPhoneNumber(addUserRequest.getUserName(), addUserRequest.getEmailAddress(),
					addUserRequest.getPhoneNumber());
			if(null == registeredUser) {
				User user = new User();
				if(addUserRequest.getUserId() != 0) {
					user.setUserId(addUserRequest.getUserId());
				}
				user.setDob(addUserRequest.getDob());
				user.setEmailAddress(addUserRequest.getEmailAddress());
				user.setFirstName(addUserRequest.getFirstName());
				user.setLastName(addUserRequest.getLastName());
				user.setLocation(addUserRequest.getLocation());
				user.setPassword(addUserRequest.getPassword());
				user.setPhoneNumber(addUserRequest.getPhoneNumber());
				user.setStatus("ACTIVE");
				user.setUserName(addUserRequest.getUserName());
				user.setUserType(addUserRequest.getUserType());
				User savedUser = registrationLoginService.addUser(user);
				if(savedUser != null) {
					message.setStatusCode(HttpStatus.OK.value());
					message.setStatusMessage("User added successfully.");
				}
			}
		} catch (Exception e) {
			System.out.println("Error occured while addProduct : " + e.getMessage());
		}
		return new ResponseEntity<Status>(message, HttpStatus.OK);
	}
	
	@PostMapping("user-search")
	public User userSearch(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, 
			@RequestBody UserRequest userRequest) {
		System.out.println("userSearch");
		List<User> users = null;
		try {
			users = registrationLoginService.userSearch(userRequest);
			if(null != users && users.size() > 0) {
				return users.get(0);
			}
		} catch (Exception e) {
			System.out.println("Error occured while fetchProductByAdvancedSearch : " + e.getMessage());
		}
		return null;
	}
	
	@GetMapping("fetch-all-users")
	public List<User> fetchAllUsers( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("fetchAllUsers");
		List<User> userList = null;
		try {
			userList = registrationLoginService.fetchAllUsers();
		} catch (Exception e) {
			System.out.println("Error occured while fetchProductById : " + e.getMessage());
		}
		return userList;
	}
	
}
