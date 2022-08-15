package com.Quiz_App.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz_App.dto.ResponseData;
import com.Quiz_App.dto.UserDto;
import com.Quiz_App.services.UserService;

@RestController
@RequestMapping("/")
public class UserController {
	
	
	@Autowired
	private UserService userService; 
	
	@PostMapping("/createUser")
	public ResponseData createUser(@RequestBody UserDto userDto ) {
		return userService.createUser(userDto);
	}
	
	@GetMapping("/viewScoreList")
	public ResponseData viewScoreList() {
		return userService.viewScoreList();
	}
	
	@GetMapping("/viewScoreById/{id}")
	public ResponseData viewScoreById(@PathVariable Long id) {
		return userService.viewScoreById(id);
	} 

}
