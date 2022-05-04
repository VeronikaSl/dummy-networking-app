package com.dummy.networkapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "ref_post_id")
	private long refPostId;
	
	@Column(name = "likes")
	private int likes;
	
	public Post() {
		
	}
	
	public Post(String user, String message, int refPostId) {
		this.user = user;
		this.message = message;
		this.refPostId = refPostId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getRefPostId() {
		return refPostId;
	}

	public void setRefPostId(long refPostId) {
		this.refPostId = refPostId;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
}
