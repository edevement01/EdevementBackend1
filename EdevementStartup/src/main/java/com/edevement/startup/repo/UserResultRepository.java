package com.edevement.startup.repo;

import org.springframework.data.repository.CrudRepository;

import com.edevement.startup.model.UserResult;

public interface UserResultRepository  extends CrudRepository<UserResult, Integer> {
	
	public UserResult findByUserId(int userId);

}
