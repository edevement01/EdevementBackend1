package com.edevement.startup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question_answer")
public class QuestionAnswer implements Serializable {

	private static final long serialVersionUID = 2288774299894885270L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "q_answer_id")
	private int questionAnswerId;
	@Column(name = "q_id")
	private int questionId;
	@Column(name = "q_answer")
	private String questionAnswer;
	
	public int getQuestionAnswerId() {
		return questionAnswerId;
	}
	public void setQuestionAnswerId(int questionAnswerId) {
		this.questionAnswerId = questionAnswerId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	
}
