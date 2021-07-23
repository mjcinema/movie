package com.icia.mjcinema.dto;

import com.icia.mjcinema.controller.UserController;
import com.icia.mjcinema.domain.User;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class UpdateUserForm {

	public static UserController fromMember;
	private String username;
	private String name;
	private String password;
	private String birth;
	private String email;
	private String address;
	private String imageName;

	private MultipartFile file;

	public static UpdateUserForm fromMember(User user) {
		UpdateUserForm form = new UpdateUserForm();
		form.setUsername(user.getUsername());
		form.setName(user.getName());
		form.setPassword(user.getPassword());
		form.setBirth(user.getBirth());
		form.setAddress(user.getAddress());
		form.setEmail(user.getEmail());
		form.setImageName(user.getImageName());
		
		return form;
	}

	public static User toUser(UpdateUserForm form) {
		User user = new User();
		user.setUsername(form.getUsername());
		user.setName(form.getName());
		user.setPassword(form.getPassword());
		user.setBirth(form.getBirth());
		user.setAddress(form.getAddress());
		user.setEmail(form.getEmail());
		user.setImageName(form.getImageName());

		return user;
	}
}
