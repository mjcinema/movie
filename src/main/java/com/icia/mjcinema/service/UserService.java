package com.icia.mjcinema.service;

import java.io.IOException;
import java.util.List;


import com.icia.mjcinema.domain.Authority;
import com.icia.mjcinema.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.icia.mjcinema.mapper.UserMapper;
import com.icia.mjcinema.dto.LoginForm;
import com.icia.mjcinema.dto.RegistrationForm;
import com.icia.mjcinema.dto.UpdateUserForm;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

	private final UserMapper userMapper;

	public User join(RegistrationForm registrationForm) {

		User user = registrationForm.toUser();

		userMapper.insertUser(user);
		for (Authority authority : user.getAuthorities()) {
			System.out.println(authority.getUsername());
			userMapper.insertAuthority(authority);
		}

		return userMapper.getUserById(user.getId());

	}

	private String saveImage(MultipartFile image) throws IllegalStateException, IOException {
		MultipartFile mfile = image;
		String mfilename = mfile.getOriginalFilename();
		mfilename = System.currentTimeMillis() + "-" + mfilename;
		String savePath ="";

//		if(!mfile.isEmpty()) {
//			mfile.transferTo(new File(savePath));
//		}
		mfilename = "default-image.jpg";
		return mfilename;
	}

	public List<User> getUsers() {
		return userMapper.getUsers();
	}

	public User login(LoginForm loginForm) {
		User user = userMapper.getUserByUsername(loginForm.getUsername());
		if(user == null || !loginForm.getPassword().equals(user.getPassword())) {
			throw new IllegalStateException("아이디나 비밀번호가 일치하지 않습니다.");
		}
		return user;
		
	}

	public String idCheck(String username) {
		User checkResult = userMapper.getUserByUsername(username);
		String result = "";
		
		if(checkResult == null) {
			result = "x";
		} else {
			result = "ok";
		}
		
		return result;
	}

	public UpdateUserForm user(String username) {

		User user = userMapper.getUserByUsername(username);

		return UpdateUserForm.fromMember(user);
	}


	public void leaveUser(String username) {
		User user = userMapper.getUserByUsername(username);
		if (user == null) {
			throw new IllegalArgumentException("유저가 없습니다.");
		}
		userMapper.deleteUser(username);
	}

	public User getUserByUsername(String username) {
		return userMapper.getUserByUsername(username);

	}

	public void updateProfileImage(String username, MultipartFile file) throws IllegalStateException, IOException {
		try {
			//1. 사용자 찾기
			User user = userMapper.getUserByUsername(username);
			//2. 이미지 저장
			String filename = saveImage(file);
			//3. 프로필 이미지 주소 변경
			user.setImageName(filename);

			userMapper.updateImage(user); }
		catch (Exception e) {

		}
	}

    public void updateUser(User user) {
		userMapper.updateUser(user);

	}
}
