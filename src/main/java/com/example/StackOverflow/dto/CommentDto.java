package com.example.StackOverflow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CommentDto {
	private String commentType;
	private String text;
	private String userId;
	private String parentId;

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"commentType = '" + commentType + '\'' + 
			",text = '" + text + '\'' + 
			",userId = '" + userId + '\'' + 
			",parentId = '" + parentId + '\'' + 
			"}";
		}
}
