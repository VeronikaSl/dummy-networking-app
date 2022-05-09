package com.dummy.networkapp.service;

import com.dummy.networkapp.domain.Post;
import com.dummy.networkapp.dto.PostDto;
import com.dummy.networkapp.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postRepository;

    public Post getById(Long id) {
        return postRepository.findById(id).get();
    }
}
