package com.dummy.networkapp.controller;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<PostDto> findAllPosts() {
        List<Post> posts = postService.findAllPosts();
        return posts.stream()
                .map(postConverter::convert)
                .collect(Collectors.toList());
    }
	
	//TODO: @Veronika: I guess that's a bad mapping implementation, it seems to break the rules. How would be the right way?
	@GetMapping("/{id}/answers")
    public List<PostDto> findAnswersForPost(@PathVariable Long id) {
		List<Post> posts = (List<Post>) postService.findAnswersToPostId(id);
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
    public PostDto findOnePost(@PathVariable Long id) {
        return postConverter.convert(postService.getPostById(id));
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
    	postService.getPostById(id);
    	postService.deletePostById(id);
    }

    @PutMapping("/{id}")
    public PostDto updatePost(@RequestBody PostDto post, @PathVariable Long id) {
        if (post.getId() != id) {
         
        }
        postService.getPostById(id);
        return postConverter.convert(
        		postService.savePost(
        				postConverter.convert(post)
        		));
    }


}
