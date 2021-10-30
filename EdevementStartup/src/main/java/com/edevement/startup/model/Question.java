package com.edevement.startup.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Question  implements Serializable {

	private static final long serialVersionUID = -1604412663307537697L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "q_id")
	private int questionId;
	@Column(name = "q_type")
	private String questionType;
	@Column(name = "q_category")
	private String questionCategory;
	@Column(name = "q_points")
	private int questionPoints;
	@Column(name = "q_description")
	private String questionDescription;
	@Type( type = "json")
	@Column(name = "q_option", columnDefinition = "json")
	private List<String> questionOption;
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestionCategory() {
		return questionCategory;
	}
	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}
	public int getQuestionPoints() {
		return questionPoints;
	}
	public void setQuestionPoints(int questionPoints) {
		this.questionPoints = questionPoints;
	}
	public String getQuestionDescription() {
		return questionDescription;
	}
	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}
	public List<String> getQuestionOption() {
		return questionOption;
	}
	public void setQuestionOption(List<String> questionOption) {
		this.questionOption = questionOption;
	}
	
}
