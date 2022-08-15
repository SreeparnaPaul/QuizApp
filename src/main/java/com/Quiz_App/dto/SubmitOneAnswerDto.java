package com.Quiz_App.dto;


import lombok.Data;

@Data
public class SubmitOneAnswerDto {
	
	private String userAnswer;
	private Integer questionId;

}
