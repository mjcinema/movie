package com.icia.mjcinema.domain;

import lombok.*;

@NoArgsConstructor
@Getter @Setter
public class User {

	private Long id;
	private String username;
	private String password;
	private String email;
	private String name;
	private String birth;
	private String address;
	private String imageName;
	private boolean enabled;


	@Builder
	public User(String username, String password, String email, String name, String birth, String address) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.address = address;
	}
}
