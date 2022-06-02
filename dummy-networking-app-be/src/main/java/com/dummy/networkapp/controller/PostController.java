package com.dummy.networkapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.networkapp.converter.PostConverter;
import com.dummy.networkapp.domain.Post;
import com.dummy.networkapp.dto.PostDto;
import com.dummy.networkapp.service.PostService;


@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	@Autowired
	private PostConverter postConverter;
	
	@GetMapping
    public ResponseEntity<List<PostDto>> findAllPosts() {
        List<Post> posts = postService.findAllPosts();
        List<PostDto> postsDto = posts.stream()
                .map(postConverter::convert)
                .collect(Collectors.toList());
        return new ResponseEntity<>(postsDto, HttpStatus.OK);
    }
	
	@GetMapping("/{id}/answers")
    public List<PostDto> findAnswersForPost(@PathVariable Long id) {
		List<Post> posts = postService.findAnswersToPostId(id);
        return posts.stream()
          .map(postConverter::convert)
          .collect(Collectors.toList());
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto post) {
        PostDto newpost = postConverter.convert(
        		postService.savePost(
        				postConverter.convert(post)
        		));
        return new ResponseEntity<>(newpost, HttpStatus.CREATED);
    }
	
	@GetMapping("/{id}")
    // https://www.baeldung.com/spring-response-entity
    public ResponseEntity<PostDto> findOnePost(@PathVariable Long id) {
	    //return new
        PostDto postDto = postConverter.convert(postService.getPostById(id));
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    //
    public void deletePost(@PathVariable Long id) {
    	postService.deletePostById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto post) {
        PostDto postDto = postConverter.convert(
        		postService.savePost(
        				postConverter.convert(post)
        		));
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }
    
    @PutMapping("/{id}/like")
    public ResponseEntity<PostDto> addLike(@PathVariable Long id) {
    	PostDto postDto = postConverter.convert(postService.getPostById(id));
    	postDto.setLikes(postDto.getLikes() + 1);
    	return new ResponseEntity<>(
    			postConverter.convert(
    					postService.savePost(postConverter.convert(postDto))),
    			HttpStatus.OK);
    }

}
