package com.edevement.startup.repo;

import org.springframework.data.repository.CrudRepository;

import com.edevement.startup.model.QuestionAnswer;

public interface QuestionAnswerRepository  extends CrudRepository<QuestionAnswer, Integer> {
	
	public QuestionAnswer findByQuestionId(int questionId);

}
