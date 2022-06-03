package com.dummy.networkapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.networkapp.domain.Post;
import com.dummy.networkapp.exception.PostNotFoundException;
import com.dummy.networkapp.repository.PostRepository;

//TODO: add error for "tree post"
//TODO: emoticon converter 
//TODO: DB

@Service
public class PostService {
	
	@Autowired
	private EmoticonConverter emoticonConverter;
	
	@Autowired
    private PostRepository postRepository;

    public Post getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(PostNotFoundException::new);
        return post;
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
		return postRepository.findByRefPostId(id);
	}

}
