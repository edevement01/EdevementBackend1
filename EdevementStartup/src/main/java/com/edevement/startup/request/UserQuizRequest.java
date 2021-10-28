package com.edevement.startup.request;

import java.util.List;

public class UserQuizRequest {
	
	private int userId;
	private List<UserAnswerRequest> userAnswerRequest;
	
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
	
}
