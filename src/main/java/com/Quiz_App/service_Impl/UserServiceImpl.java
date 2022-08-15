package com.Quiz_App.service_Impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quiz_App.Repository.UserRepository;
import com.Quiz_App.dto.ResponseData;
import com.Quiz_App.dto.UserDto;
import com.Quiz_App.entites.User;
import com.Quiz_App.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public ResponseData createUser(UserDto userDto) {
		ResponseData responseData=new ResponseData();
		if(!Objects.isNull(userDto.getFullName())) {
			if(!userDto.getFullName().trim().equals("")) {
				User user=new User();
				user.setFullName(userDto.getFullName());
				user.setScore(0l);
				User savedUser=userRepository.save(user);
				responseData.setStatus(true);
				responseData.setMessage("Success");
				responseData.setData("User added successfully");
			}
		}
		return responseData;
	}

	@Override
	public ResponseData viewScoreList() {
		List<User> viewScoreList =new ArrayList<>();
		userRepository.findAll().forEach(viewScoreList :: add);
		ResponseData responseData=new ResponseData();
		responseData.setStatus(true);
		responseData.setMessage("Success");
		responseData.setData(viewScoreList);
		return responseData;
	}

	@Override
	public ResponseData viewScoreById(Long id) {
		User viewScoreById = userRepository.findById(id).get();
		ResponseData responseData=new ResponseData();
		responseData.setStatus(true);
		responseData.setMessage("Success");
		responseData.setData(viewScoreById);
		return responseData;
	}

}
