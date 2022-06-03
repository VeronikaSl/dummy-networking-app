package com.dummy.networkapp.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dummy.networkapp.domain.Post;
import com.dummy.networkapp.dto.PostDto;

@Component
public class PostConverter {

	@Autowired
	private UserConverter userConverter;
	
    public Post convert(PostDto post) {
        return Post.builder()
        		.id(post.getId())
                .userName(post.getUserName())
                .user(userConverter.convert(post.getUser()))
                .message(post.getMessage())
                .refPostId(post.getRefPostId())
                .likes(post.getLikes())
                .build();
    }

    public PostDto convert(Post post) {
        return PostDto.builder()
        		.id(post.getId())
                .userName(post.getUserName())
                .user(userConverter.convert(post.getUser()))
                .message(post.getMessage())
                .refPostId(post.getRefPostId())
                .likes(post.getLikes())
                .build();
    }
}
