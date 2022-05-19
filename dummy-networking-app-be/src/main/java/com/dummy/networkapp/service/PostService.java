package com.dummy.networkapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.networkapp.domain.Post;
import com.dummy.networkapp.exception.PostNotFoundException;
import com.dummy.networkapp.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
    private PostRepository postRepository;

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

	public List<Post> findAllPosts() {
		return (List<Post>) postRepository.findAll();
	}

	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	public void deletePostById(Long id) {
		postRepository.deleteById(id);
	}
	
	public List<Post> findAnswersToPostId(Long id) {
		return postRepository.findByRefId(id);
	}

}
