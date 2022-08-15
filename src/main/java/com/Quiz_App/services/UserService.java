package com.Quiz_App.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Quiz_App.dto.ResponseData;
import com.Quiz_App.dto.UserDto;
import com.Quiz_App.entites.User;

@Service
public interface UserService {

	public ResponseData createUser(UserDto userDto);
	public ResponseData viewScoreList();
	public ResponseData viewScoreById(Long id);

}
