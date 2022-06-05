package com.dummy.networkapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.networkapp.converter.UserConverter;
import com.dummy.networkapp.dto.UserDto;
import com.dummy.networkapp.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserConverter userConverter;
	
	/*@RequestMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable Long id){
		UserDto userDto = userConverter.convert(userService.getUserById(id));
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}*/
	
	//TODO: @Veronika: decided that I more like the Username approach if that's ok
	@RequestMapping("/{name}")
	public ResponseEntity<UserDto> getUser(@PathVariable String name){
		UserDto userDto = userConverter.convert(userService.getUserByUser(name));
		return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
	}
	
	//TODO: other CRUD features. Later... ;)
	
}
