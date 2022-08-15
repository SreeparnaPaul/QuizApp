package com.Quiz_App.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz_App.dto.QuestionDto;
import com.Quiz_App.dto.ResponseData;
import com.Quiz_App.dto.SubmitAllAnswersDto;
import com.Quiz_App.entites.Questions;
import com.Quiz_App.services.QuestionService;

@RestController
@RequestMapping("/")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	
	@GetMapping("/getCategoryById/{id}")
	public ResponseData getQuestionsById(@PathVariable Integer id) {
		return questionService.getQuestionsById(id);	
	}
	
	@GetMapping("/getAllQuestions")
	public ResponseData getAllQuestions(){
		return questionService.getAllQuestions();
	}
	
	@PostMapping("/createQuestions")
    public ResponseData createQuestions(@RequestBody QuestionDto questionDto) {
		return questionService.createQuestions(questionDto);
    	
    }
	
	@PostMapping("/submitAllAnswers")
	public ResponseData submitAllAnswers(@RequestBody SubmitAllAnswersDto submitAllAnswersDto) {
		return questionService.submitAllAnswers(submitAllAnswersDto);
	}
}
