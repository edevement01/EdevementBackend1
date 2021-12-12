package com.edevement.startup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_result")
public class UserResult  implements Serializable {

	private static final long serialVersionUID = -5106986589501908345L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_result_id")
	private int userResultId;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "user_marks")
	private int userMarks;
	@Column(name = "q_type")
	private String quizType;
	
	public int getUserResultId() {
		return userResultId;
	}
	public void setUserResultId(int userResultId) {
		this.userResultId = userResultId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserMarks() {
		return userMarks;
	}
	public void setUserMarks(int userMarks) {
		this.userMarks = userMarks;
	}
	public String getQuizType() {
		return quizType;
	}
	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}

}
