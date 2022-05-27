package com.dummy.networkapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dummy.networkapp.domain.User;
import com.dummy.networkapp.exception.UserNotFoundException;
import com.dummy.networkapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User getUserById(Long id){
		return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
	}
	
	public User getUserByUser(String user) {
		return userRepository.findUserByUser(user);
	}

}
