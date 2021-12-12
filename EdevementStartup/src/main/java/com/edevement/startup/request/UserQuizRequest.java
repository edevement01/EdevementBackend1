package com.edevement.startup.request;

import java.util.List;

public class UserQuizRequest {
	
	private int userId;
	private List<UserAnswerRequest> userAnswerRequest;
	private String quizType;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<UserAnswerRequest> getUserAnswerRequest() {
		return userAnswerRequest;
	}
	public void setUserAnswerRequest(List<UserAnswerRequest> userAnswerRequest) {
		this.userAnswerRequest = userAnswerRequest;
	}
	public String getQuizType() {
		return quizType;
	}
	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}
	
}
