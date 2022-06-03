package com.dummy.networkapp.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@Builder
// TODO: @Daniel, I have added 2 more cool Lombok annotations;)
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user")
	private String userName;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "username")
	private User user;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "ref_post_id")
	private Long refPostId;
	
	@Column(name = "likes")
	private int likes;

	@Enumerated(EnumType.STRING)
	@Column(name = "topic")
	private PostTopic postTopic;
	
	public Post(String userName, String message) {
		this.userName = userName;
		this.message = message;
	}

}
