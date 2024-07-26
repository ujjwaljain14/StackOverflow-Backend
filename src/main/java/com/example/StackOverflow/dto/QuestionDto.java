package com.example.StackOverflow.dto;

import com.example.StackOverflow.models.Topic;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter

public class QuestionDto {

	@NonNull
	private String title;

	@NonNull
	private String body;

	@NonNull
	private String userId;

	private List<String> topicIds;

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"title = '" + title + '\'' + 
			",body = '" + body + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}
