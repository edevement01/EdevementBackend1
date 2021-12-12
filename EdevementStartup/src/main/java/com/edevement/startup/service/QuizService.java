package com.edevement.startup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.edevement.startup.model.Question;
import com.edevement.startup.model.QuestionAnswer;
import com.edevement.startup.model.QuizType;
import com.edevement.startup.model.UserResult;
import com.edevement.startup.repo.QuestionAnswerRepository;
import com.edevement.startup.repo.QuizRepository;
import com.edevement.startup.repo.QuizTypeRepository;
import com.edevement.startup.repo.UserResultRepository;
import com.edevement.startup.request.UserAnswerRequest;
import com.edevement.startup.request.UserQuizRequest;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class QuizService {
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Autowired
	private QuestionAnswerRepository questionAnswerRepository;
	
	@Autowired
	private UserResultRepository userResultRepository;
	
	@Autowired
	private QuizTypeRepository quizTypeRepository;
	
	public List<Question> findByQuestionTypeAndQuestionCategory(String questionType, String questionCategory) {
		return quizRepository.findByQuestionTypeAndQuestionCategory(questionType, questionCategory);
	}
	
	public int submitQuiz(UserQuizRequest userQuizRequest) {
		int resultPoints = 0;
		for (UserAnswerRequest userAnswerRequest : userQuizRequest.getUserAnswerRequest()) {
			QuestionAnswer questionAnswer = questionAnswerRepository.findByQuestionId(userAnswerRequest.getQuestionId());
			if(questionAnswer.getQuestionAnswer().equalsIgnoreCase(userAnswerRequest.getAnswer())) {
				resultPoints = resultPoints + quizRepository.findById(userAnswerRequest.getQuestionId()).get().getQuestionPoints();
			} else {
				resultPoints = resultPoints -1;
			}
		}
		saveUserResult(userQuizRequest.getUserId(), resultPoints, userQuizRequest.getQuizType());
		return resultPoints;
	}
	
	private void saveUserResult(int userId, int points, String quizType) {
		UserResult userResult = new UserResult();
		userResult.setUserId(userId);
		userResult.setUserMarks(points);
		userResult.setQuizType(quizType);
		userResultRepository.save(userResult);
	}
	
	public List<QuizType> fetchQuizTypes() {
		List<QuizType> quizTypes = new ArrayList<>();
		Iterable<QuizType> quizTypeList = quizTypeRepository.findAll();
		for (QuizType quizType : quizTypeList) {
			quizTypes.add(quizType);
		}
		return quizTypes;
	}

}
