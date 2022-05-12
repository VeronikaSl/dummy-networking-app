package com.dummy.networkapp.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
