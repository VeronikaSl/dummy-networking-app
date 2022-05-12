package com.dummy.networkapp.controller;

import com.dummy.networkapp.exception.PostNotFoundException;
import com.dummy.networkapp.repository.PostRepository;
import com.dummy.networkapp.service.PostService;
import com.dummy.networkapp.converter.PostConverter;
import com.dummy.networkapp.domain.Post;
import com.dummy.networkapp.dto.PostDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	@Autowired
	private PostConverter postConverter;
	
	@GetMapping
    public Iterable findAllPosts() {
        return postService.findAll();
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //TODO: @Veronika: don't know if I am using the converter right or in the right place (could be PostService as well?), so tell me ;)
    public PostDto createPost(@RequestBody PostDto post) {
        return postConverter.convert(
        		postService.save(
        				postConverter.convert(post)
        		));
    }
	
	@GetMapping("/{id}")
    public PostDto findOnePost(@PathVariable Long id) {
        return postConverter.convert(postService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
    	postService.getById(id);
    	postService.deleteById(id);
    }

    @PutMapping("/{id}")
    public PostDto updatePost(@RequestBody PostDto post, @PathVariable Long id) {
        if (post.getId() != id) {
         
        }
        postService.getById(id);
        return postConverter.convert(
        		postService.save(
        				postConverter.convert(post)
        		));
    }

}
