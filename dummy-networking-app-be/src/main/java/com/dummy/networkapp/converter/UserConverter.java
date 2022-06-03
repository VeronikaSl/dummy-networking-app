package com.dummy.networkapp.converter;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dummy.networkapp.domain.User;
import com.dummy.networkapp.dto.UserDto;

@Component
public class UserConverter {
	
	//@Autowired
	//private PostConverter postConverter;
	
	//@Autowired
	//private GroupConverter groupConverter;

	public UserDto convert(User user) {
		UserDto userDto = UserDto.builder()
				.user(user.getUserName())
				.email(user.getEmail())
				.selfIntroduction(user.getSelfIntroduction())
				//.allUserPosts(user.getAllUserPosts().stream()
				//		.map(postConverter::convert)
				//		.collect(Collectors.toList()))
				//.groups(user.getGroups().stream()
				//		.map(groupConverter::convert)
				//		.collect(Collectors.toList()))
				.build();
		return userDto;
	}
	
	public User convert(UserDto userDto) {
		User user = User.builder()
				.userName(userDto.getUser())
				.email(userDto.getEmail())
				.selfIntroduction(userDto.getSelfIntroduction())
				//.allUserPosts(userDto.getAllUserPosts().stream()
				//		.map(postConverter::convert)
				//		.collect(Collectors.toList()))
				//.groups(userDto.getGroups().stream()
				//		.map(groupConverter::convert)
				//		.collect(Collectors.toList()))
				.build();
		return user;
	}
}
