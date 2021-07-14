package com.icia.mjcinema.dto;

import com.icia.mjcinema.domain.User;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class UpdateUserForm {
	
	private String username;
	private String name;
	private String password;
	private String birth;
	private String email;
	private String address;
	private String filename;

	private MultipartFile file;
	
	public static UpdateUserForm fromMember(User user) {
		UpdateUserForm form = new UpdateUserForm();
		form.setUsername(user.getUsername());
		form.setName(user.getName());
		form.setPassword(user.getPassword());
		form.setBirth(user.getBirth());
		form.setAddress(user.getAddress());
		form.setEmail(user.getEmail());
		form.setFilename(user.getImageName());
		
		return form;
	}
}
