package com.ashokit.model;


import lombok.Data;

@Data
public class HISCreateAccountBinding {
	
	private Integer userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String gender;
	
	private String role;

}
