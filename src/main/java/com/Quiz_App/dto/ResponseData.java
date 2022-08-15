package com.Quiz_App.dto;

import lombok.Data;

@Data
public class ResponseData {
	
	private String message;
	private Boolean status;
	private Object data;

}
