package com.Quiz_App.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Quiz_App.dto.QuestionDto;
import com.Quiz_App.dto.ResponseData;
import com.Quiz_App.dto.SubmitAllAnswersDto;
import com.Quiz_App.entites.Questions;

@Service
public interface QuestionService {
	public ResponseData getAllQuestions();
	public ResponseData createQuestions(QuestionDto questionDto);
	public ResponseData getQuestionsById(Integer id);
	public ResponseData submitAllAnswers(SubmitAllAnswersDto submitAllAnswersDto);

}
