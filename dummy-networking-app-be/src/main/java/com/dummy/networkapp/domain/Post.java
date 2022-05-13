package com.dummy.networkapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@Builder
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "ref_post_id")
	private Long refPostId;
	
	@Column(name = "likes")
	private int likes;
	
	public Post() {
		
	}
	
	public Post(String user, String message) {
		this.user = user;
		this.message = message;
	}

	private Post(Long id, String user, String message, Long refPostId, int likes) {
		this.id = id;
		this.user = user;
		this.message = message;
		this.refPostId = refPostId;
		this.likes = likes;
	}

}
