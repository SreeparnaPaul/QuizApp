package com.Quiz_App.service_Impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quiz_App.Repository.QuestionRepository;
import com.Quiz_App.Repository.UserRepository;
import com.Quiz_App.dto.QuestionDto;
import com.Quiz_App.dto.ResponseData;
import com.Quiz_App.dto.SubmitAllAnswersDto;
import com.Quiz_App.dto.SubmitOneAnswerDto;
import com.Quiz_App.entites.Questions;
import com.Quiz_App.entites.User;
import com.Quiz_App.services.QuestionService;


@Service
public class QuestionServiceImpl implements QuestionService {
	
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public ResponseData getQuestionsById(Integer id) {
		 Questions question = questionRepository.findById(id).get();
		 ResponseData responseData=new ResponseData();
			responseData.setStatus(true);
			responseData.setMessage("Success");
			responseData.setData(question);
			return responseData;
	}

	@Override
	public ResponseData getAllQuestions() {
		List<Questions> questions=new ArrayList<>();
		questionRepository.findAll().forEach(questions::add);
		ResponseData responseData=new ResponseData();
		responseData.setStatus(true);
		responseData.setMessage("Success");
		responseData.setData(questions);
		return responseData;
	}

	@Override
	public ResponseData createQuestions(QuestionDto questionDto) {
		ResponseData responseData =new ResponseData();
	    Questions questions = convertRequestDtoToEntity(questionDto);
	    questions.setCreatedAt(LocalDateTime.now());
	    Questions savedQuestions =questionRepository.save(questions);
	    if (!Objects.isNull(savedQuestions)) {
			responseData.setStatus(true);
			responseData.setMessage("Success");
			responseData.setData("Question added successfully");
		} else {
			responseData.setStatus(false);
			responseData.setMessage("Failed");
			responseData.setData("Something went wrong!");
		}
		return responseData;
	}
	
	@Override
	public ResponseData submitAllAnswers(SubmitAllAnswersDto submitAllAnswersDto) {
		ResponseData responseData=new ResponseData();
		User existedUser = userRepository.findById(submitAllAnswersDto.getUserId()).get();
		if(!Objects.isNull(submitAllAnswersDto.getSubmitOneAnswerDto())) {
			if(submitAllAnswersDto.getSubmitOneAnswerDto().size()!=0) {
				for(SubmitOneAnswerDto oneAnswer:submitAllAnswersDto.getSubmitOneAnswerDto()) {
					Questions answersQuestions = questionRepository.findById(oneAnswer.getQuestionId()).get();
					if(answersQuestions.getRightAnswer().equals(oneAnswer.getUserAnswer())) {
						existedUser.setScore(existedUser.getScore()+1l);
						userRepository.save(existedUser);
						responseData.setStatus(true);
						responseData.setMessage("Success");
						responseData.setData("Right Answer");
						return responseData;
					}
					else {
						responseData.setStatus(true);
						responseData.setMessage("Success");
						responseData.setData("Wrong Answer");
						return responseData;
					}
				}
			}
		}
		return responseData;
	}
	
	public Questions convertRequestDtoToEntity(QuestionDto questionDto) {
		Questions questions=new Questions();
		questions.setQuestion(questionDto.getQuestion());
		String answerString="";
		for(String answer:questionDto.getAnswers()) {
			answerString=answerString+","+answer;
		}
		
		questions.setAnswers(answerString.substring(1,answerString.length()));
		questions.setRightAnswer(questionDto.getRightAnswer());
		
		return questions;
		
	}

	

	

}
