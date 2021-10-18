package com.edevement.startup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edevement.startup.model.User;

@Repository
public interface RegistrationLoginRepository extends CrudRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.userName = ?1 and u.password = ?2 and u.status = 'active'")
    public List<User> userSearch(String userName, String password);
	
	public User findByUserName(String userName);
	
	public User findByUserNameOrEmailAddressOrPhoneNumber(String userName, String emailAddress, String phoneNumber);

}
