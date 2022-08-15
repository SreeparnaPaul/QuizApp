package com.Quiz_App.dto;

import java.util.List;

import lombok.Data;

@Data
public class SubmitAllAnswersDto {
	
	
	private Long userId;
	private List<SubmitOneAnswerDto> submitOneAnswerDto;

}
