package com.edevement.startup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edevement.startup.model.User;
import com.edevement.startup.repo.RegistrationLoginRepository;
import com.edevement.startup.request.UpdateUserRequest;
import com.edevement.startup.request.UserRequest;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class RegistrationLoginService {
	
	@Autowired
	private RegistrationLoginRepository registrationLoginRepository;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public User addUser(User user) { 
		 return registrationLoginRepository.save(user);
	}
	
	public List<User> userSearch(UserRequest userRequest) { 
		return registrationLoginRepository.userSearch(userRequest.getUserName(), userRequest.getPassword());
	}
	
	public List<User> fetchAllUsers() { 
		return (List<User>) registrationLoginRepository.findAll(); 
	}
	
	public User updateUser(UpdateUserRequest updateUserRequest) {
		User userToBeUpdated = null;
		Optional<User> userPresent = registrationLoginRepository.findById(updateUserRequest.getUserId());
		if(userPresent.isPresent()) {
			userToBeUpdated = userPresent.get();
			userToBeUpdated.setDob(updateUserRequest.getDob());
			userToBeUpdated.setFirstName(updateUserRequest.getFirstName());
			userToBeUpdated.setLastName(updateUserRequest.getLastName());
			userToBeUpdated.setLocation(updateUserRequest.getLocation());
			userToBeUpdated.setEmailAddress(updateUserRequest.getEmailAddress());
			userToBeUpdated.setPhoneNumber(updateUserRequest.getPhoneNumber());
			userToBeUpdated.setUserName(updateUserRequest.getUserName());
			userToBeUpdated.setPassword(updateUserRequest.getPassword());
			userToBeUpdated.setUserType(updateUserRequest.getUserType());	
			registrationLoginRepository.save(userToBeUpdated);
		}
		return userToBeUpdated;
	}
	
	
	public User findByUserName(String userName) {
		return registrationLoginRepository.findByUserName(userName);
	}
	
	public User findByUserNameOrEmailAddressOrPhoneNumber(String userName, String emailAddress, String phoneNumber) {
		return registrationLoginRepository.findByUserNameOrEmailAddressOrPhoneNumber(userName, emailAddress, phoneNumber);
	}
	
	public User findByUserId(int userId) {
		Optional<User> user = registrationLoginRepository.findById(userId);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

}
