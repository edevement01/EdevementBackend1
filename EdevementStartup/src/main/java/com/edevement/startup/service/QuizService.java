package com.edevement.startup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edevement.startup.model.Question;
import com.edevement.startup.repo.QuizRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepository;
	
	public List<Question> findByQuestionTypeAndQuestionCategory(String questionType, String questionCategory) {
		return quizRepository.findByQuestionTypeAndQuestionCategory(questionType, questionCategory);
	}

}
