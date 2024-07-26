package com.example.StackOverflow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AnswerDto{
	private String text;
	private String userId;

	@Override
 	public String toString(){
		return 
			"AnswerDto{" + 
			"text = '" + text + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}
