package com.dummy.networkapp.converter;

import com.dummy.networkapp.domain.Post;
import com.dummy.networkapp.dto.PostDto;

public class PostConverter {

    public Post convert(PostDto post) {
        return Post.builder()
                .user(post.getName())
                .build();
    }

    public PostDto convert(Post post) {
        return PostDto.builder()
                .name(post.getUser())
                .build();
    }
}
