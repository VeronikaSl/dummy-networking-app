package com.dummy.networkapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dummy.networkapp.converter.PostConverter;
import com.dummy.networkapp.domain.Post;
import com.dummy.networkapp.dto.PostDto;
import com.dummy.networkapp.service.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostService postService;
	@Autowired
	private PostConverter postConverter;
	
	@GetMapping
    public List<PostDto> findAllPosts() {
        List<Post> posts = postService.findAllPosts();
        return posts.stream()
                .map(postConverter::convert)
                .collect(Collectors.toList());
    }
	
	//TODO: @Veronika: I guess that's a bad mapping implementation, it seems to break the rules. How would be the right way?
	@GetMapping("/{id}/answers")
    public List<PostDto> findAnswersForPost(@PathVariable Long id) {
		List<Post> posts = postService.findAnswersToPostId(id);
        return posts.stream()
          .map(postConverter::convert)
          .collect(Collectors.toList());
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //TODO: @Veronika: don't know if I am using the converter right or in the right place (could be PostService as well?), so tell me ;)
    public PostDto createPost(@RequestBody PostDto post) {
        return postConverter.convert(
        		postService.savePost(
        				postConverter.convert(post)
        		));
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
	    // TODO: @Daniel why we need here getPostById(id)?
    	postService.getPostById(id);
    	postService.deletePostById(id);
    }

    // ID is not needed
    @PutMapping("/{id}")
    public PostDto updatePost(@RequestBody PostDto post, @PathVariable Long id) {
//        if (post.getId() != id) {
//
//        }
        // TODO: @Daniel why we need here getPostById(id)?
        postService.getPostById(id);
        return postConverter.convert(
        		postService.savePost(
        				postConverter.convert(post)
        		));
    }


}
