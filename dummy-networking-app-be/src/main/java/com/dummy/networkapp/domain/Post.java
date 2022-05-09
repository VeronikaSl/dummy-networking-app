package com.dummy.networkapp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	// Post, auf das geantwortet wurde
//	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//	@JoinColumn(name = "ref_post_id", insertable = false, updatable = false)
//	private Post referencePost;
//
//	// Antwortposts
//	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//	@JoinColumn(name = "id", insertable = false, updatable = false)
//	private List<Post> answers;
	
	@Column(name = "likes")
	private int likes;
	
	public Post() {
		
	}
	
	public Post(String user, String message) {
		this.user = user;
		this.message = message;
	}

//	public Post getReferencePost() {
//		return referencePost;
//	}
//
//	public void setReferencePost(Post referencePost) {
//		this.referencePost = referencePost;
//	}
//
//	public List<Post> getAnswers() {
//		return answers;
//	}
//
//	public void setAnswers(List<Post> answers) {
//		this.answers = answers;
//	}

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getUser() {
//		return user;
//	}
//
//	public void setUser(String user) {
//		this.user = user;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//
//	public Long getRefPostId() {
//		return refPostId;
//	}
//
//	public void setRefPostId(Long refPostId) {
//		this.refPostId = refPostId;
//	}
//
//	public int getLikes() {
//		return likes;
//	}
//
//	public void setLikes(int likes) {
//		this.likes = likes;
//	}
}
