package com.icia.mjcinema.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter @Setter
public class User {

	private Long id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String name;
	private String birth;
	private String imageName;
	private List<Authority> authorities = new ArrayList<>();

	@Builder
	public User(String username, String password, String email, String name, String birth, String address) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.address = address;
		authorities.add(new Authority(username, "ROLE_USER"));
}
}
