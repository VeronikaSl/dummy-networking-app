package com.dummy.networkapp;

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
	private PostRepository postRepository;
	
	@GetMapping
    public Iterable findAll() {
        return postRepository.findAll();
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }
	
	@GetMapping("/{id}")
    public Post findOne(@PathVariable Long id) {
        return postRepository.findById(id)
          .orElseThrow(PostNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	postRepository.findById(id)
          .orElseThrow(PostNotFoundException::new);
    	postRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Post updateBook(@RequestBody Post post, @PathVariable Long id) {
        if (post.getId() != id) {
         
        }
        postRepository.findById(id)
          .orElseThrow(PostNotFoundException::new);
        return postRepository.save(post);
    }

}
