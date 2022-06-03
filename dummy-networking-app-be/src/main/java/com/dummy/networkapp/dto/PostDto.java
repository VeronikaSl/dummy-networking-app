package com.dummy.networkapp.dto;

import com.dummy.networkapp.domain.PostTopic;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {

	private Long id;
	private UserDto user;
	private String message;
	private Long refPostId;
	private int likes;
	private PostTopic postTopic;
}
