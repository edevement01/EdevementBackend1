package com.edevement.startup.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edevement.startup.model.Question;

@Repository
public interface QuizRepository extends CrudRepository<Question, Integer> {
	
	public List<Question> findByQuestionTypeAndQuestionCategory(String questionType, String questionCategory);

}
