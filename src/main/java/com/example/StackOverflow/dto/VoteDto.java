package com.example.StackOverflow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteDto {
	private String voteType;
	private String userId;

	@Override
 	public String toString(){
		return
			"Response{" +
			"voteType = '" + voteType + '\'' +
			",userId = '" + userId + '\'' +
			"}";
		}
}
