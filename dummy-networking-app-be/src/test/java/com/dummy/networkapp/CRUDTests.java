package com.dummy.networkapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.dummy.networkapp.dto.PostDto;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDTests {

	private static final String API_ROOT = "http://localhost:8090/posts";
	
	@Test
    public void getAllPosts() {
        Response response = RestAssured.get(API_ROOT);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
	
    @Test
	public void createPost() {
		String message = "Testmessage create :)";
		PostDto postDto = createMessage(message);
		RequestSpecification request = createMessagePost(postDto);
		Response response = request.post(API_ROOT);
		
		assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
	}

	private RequestSpecification createMessagePost(PostDto postDto) {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(postDto);
		return request;
	}

	private PostDto createMessage(String message) {
		PostDto postDto = PostDto.builder()
				.message(message)
				.userName("Daniel").build();
		return postDto;
	}
	
	@Test
	public void getMessage() {
		String message = "Testmessage get :)";
		PostDto postDto = createMessage(message);
		RequestSpecification request = createMessagePost(postDto);
		Response response = request.post(API_ROOT);
		
		PostDto newPostDto = response.getBody().as(PostDto.class);
		
		response = RestAssured.get(API_ROOT + "/" + newPostDto.getId());
		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}
	
	@Test
	public void updateMessage() {
		String message = "Testmessage update :)";
		PostDto postDto = createMessage(message);
		RequestSpecification request = createMessagePost(postDto);
		Response response = request.post(API_ROOT);
		
		PostDto newPostDto = response.getBody().as(PostDto.class);
		
		newPostDto.setMessage(newPostDto.getMessage() + " - updated!");
		
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(newPostDto);
		
		response = request.put(API_ROOT + "/" + newPostDto.getId());
		PostDto updatedPost = response.getBody().as(PostDto.class);
		assertEquals(newPostDto.getMessage(), updatedPost.getMessage());
	}
	
	@Test
	public void deleteMessage() {
		String message = "Testmessage delete :)";
		PostDto postDto = createMessage(message);
		RequestSpecification request = createMessagePost(postDto);
		Response response = request.post(API_ROOT);
		
		PostDto newPostDto = response.getBody().as(PostDto.class);
		
		response = RestAssured.delete(API_ROOT + "/" + newPostDto.getId());
		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}
	
	@Test
	public void likeMessage() {
		String message = "Testmessage like :)";
		PostDto postDto = createMessage(message);
		RequestSpecification request = createMessagePost(postDto);
		Response response = request.post(API_ROOT);
		
		PostDto newPostDto = response.getBody().as(PostDto.class);
		
		response = request.put(API_ROOT + "/" + newPostDto.getId() + "/like");
		PostDto updatedPost = response.getBody().as(PostDto.class);
		assertEquals(newPostDto.getLikes()+1, updatedPost.getLikes());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
