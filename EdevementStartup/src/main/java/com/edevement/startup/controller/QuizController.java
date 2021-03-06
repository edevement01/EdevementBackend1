package com.edevement.startup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edevement.startup.model.Question;
import com.edevement.startup.model.QuizType;
import com.edevement.startup.request.UserQuizRequest;
import com.edevement.startup.service.QuizService;

@CrossOrigin(maxAge = 3600)
@RestController
public class QuizController {
	
	@Autowired
	private QuizService quizService;

	@GetMapping("fetch-questions-by-type-category")
	public List<Question> fetchQuestionsByTypeAndCategory( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			@RequestParam String questionType, @RequestParam String questionCategory) {
		List<Question> questionList = null;
		try {
			questionList = quizService.findByQuestionTypeAndQuestionCategory(questionType, questionCategory);
		} catch (Exception e) {
			System.out.println("Error occured while fetchQuestionsByTypeAndCategory : " + e.getMessage());
		}
		return questionList;
	}
	
	@PostMapping("submit-quiz")
	public int submitQuiz(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody UserQuizRequest userQuizRequest) {
		int resultPoints = 0;
		try {
			resultPoints = quizService.submitQuiz(userQuizRequest);
		} catch (Exception e) {
			System.out.println("Error occured while submitQuiz : " + e.getMessage());
		}
		return resultPoints;
		
	}
	
	@GetMapping("fetch-quiz-types")
	public List<QuizType> fetchQuizTypes(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		return quizService.fetchQuizTypes();
	}
}
