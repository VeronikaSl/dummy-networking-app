package com.dummy.networkapp.dto;

import java.util.List;

import com.dummy.networkapp.domain.Group;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
	
	public String user;
	
	public String email;
	
	public String selfIntroduction;
	
	public List<PostDto> allUserPosts;
	
	public List<GroupDto> groups;
}
