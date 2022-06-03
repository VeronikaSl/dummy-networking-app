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
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//TODO: @Veronika: converted "user" to "user_id" because Spring refused to join via String. Is there a method to join via String?
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "ref_post_id")
	private Long refPostId;
	
	@Column(name = "likes")
	private int likes;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "topic")
	private PostTopic postTopic;
	

}
