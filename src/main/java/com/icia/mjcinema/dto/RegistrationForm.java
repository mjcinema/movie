package com.icia.mjcinema.dto;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import com.icia.mjcinema.domain.User;

import lombok.Data;

@Data
public class RegistrationForm {

	private Long id;
	@NotEmpty(message="id를 입력해주세요")
	private String username;
	private String password;
	private String email;
	private String name;
	private String birth;
	private String address;

	private MultipartFile imageFile;
	
	public User toUser() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.birth(birth)
				.address(address)
				.build();
	}
}
