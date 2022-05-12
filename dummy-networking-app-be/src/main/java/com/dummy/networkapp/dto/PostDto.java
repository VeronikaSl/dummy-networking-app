package com.dummy.networkapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {

	private Long id;
	private String user;
	private String message;
	private Long refPostId;
	private int likes;
}
