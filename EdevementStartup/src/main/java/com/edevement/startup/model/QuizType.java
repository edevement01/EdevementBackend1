package com.edevement.startup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quiz_type")
public class QuizType  implements Serializable {

	private static final long serialVersionUID = 3811298206691971504L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quiz_type_id")
	private int quizTypeId;
	@Column(name = "q_type")
	private String quizType;
	
	public int getQuizTypeId() {
		return quizTypeId;
	}
	public void setQuizTypeId(int quizTypeId) {
		this.quizTypeId = quizTypeId;
	}
	public String getQuizType() {
		return quizType;
	}
	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}
	
}
