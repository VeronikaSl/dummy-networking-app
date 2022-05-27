package com.dummy.networkapp.converter;

import org.springframework.stereotype.Component;

import com.dummy.networkapp.domain.User;
import com.dummy.networkapp.dto.UserDto;

@Component
public class UserConverter {

	public UserDto convert(User user) {
		UserDto userDto = UserDto.builder()
				.user(user.getUser())
				.email(user.getEmail())
				.infotext(user.getInfotext()).build();
		return userDto;
	}
	
	public User convert(UserDto userDto) {
		User user = User.builder()
				.user(userDto.getUser())
				.email(userDto.getEmail())
				.infotext(userDto.getInfotext()).build();
		return user;
	}
}
