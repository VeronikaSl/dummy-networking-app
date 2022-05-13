package com.dummy.networkapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class CRUDTests {

	 private static final String API_ROOT = "http://localhost/posts";
	 
	@Test
    public void whenGetAllBooks_thenOK() {
        //Response response = RestAssured.get(API_ROOT);
     
        //assertEquals(HttpStatus.OK.value(), response.getStatusCode());
    }
}
