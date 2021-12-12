package com.edevement.startup.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edevement.startup.model.QuizType;

@Repository
public interface QuizTypeRepository extends CrudRepository<QuizType, Integer> {
	

}
