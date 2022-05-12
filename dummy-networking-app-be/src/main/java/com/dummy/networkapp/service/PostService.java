package com.dummy.networkapp.service;

import com.dummy.networkapp.converter.PostConverter;
import com.dummy.networkapp.domain.Post;
import com.dummy.networkapp.dto.PostDto;
import com.dummy.networkapp.exception.PostNotFoundException;
import com.dummy.networkapp.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
    private PostRepository postRepository;

    public Post getById(Long id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

	public Iterable findAll() {
		return postRepository.findAll();
	}

	public Post save(Post post) {
		return postRepository.save(post);
	}

	public void deleteById(Long id) {
		postRepository.deleteById(id);
	}

}
