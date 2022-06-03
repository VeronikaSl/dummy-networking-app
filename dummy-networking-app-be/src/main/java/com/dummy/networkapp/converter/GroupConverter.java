package com.dummy.networkapp.converter;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dummy.networkapp.domain.Group;
import com.dummy.networkapp.dto.GroupDto;

import lombok.Builder;

@Component
public class GroupConverter {

	@Autowired
	private UserConverter userConverter;
	
	public Group convert(GroupDto group) {
		return Group.builder()
				.groupName(group.getName())
				.users(group.getUsers().stream()
						.map(userConverter::convert)
						.collect(Collectors.toList()))
				.build();
	}
	
	public GroupDto convert(Group group) {
		return GroupDto.builder()
				.name(group.getGroupName())
				.users(group.getUsers().stream()
						.map(userConverter::convert)
						.collect(Collectors.toList()))
				.build();
	}
}
