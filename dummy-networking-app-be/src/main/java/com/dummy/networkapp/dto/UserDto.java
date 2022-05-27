package com.dummy.networkapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
	
	public String user;
	
	public String email;
	
	public String infotext;
}
