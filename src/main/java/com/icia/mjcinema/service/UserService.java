package com.icia.mjcinema.service;

import java.io.File;
import java.io.IOException;
import java.util.List;


import com.icia.mjcinema.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import com.icia.mjcinema.dao.UserDao;
import com.icia.mjcinema.dto.LoginForm;
import com.icia.mjcinema.dto.RegistrationForm;
import com.icia.mjcinema.dto.UpdateUserForm;


@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	public User join(RegistrationForm registrationForm) throws IllegalStateException, IOException {

		User user = registrationForm.toUser();

		String imageName = saveImage(registrationForm.getImageFile());
		user.setImageName(imageName);

		userDao.insertUser(user);

		return userDao.selectUserByUsername(user.getUsername());

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
		return userDao.selectUsers();
	}

	public User login(LoginForm loginForm) {
		User user = userDao.selectUserByUsername(loginForm.getUsername());
		if(user == null || !loginForm.getPassword().equals(user.getPassword())) {
			throw new IllegalStateException("아이디나 비밀번호가 일치하지 않습니다.");
		}
		return user;
		
	}

	public String idCheck(String username) {
		User checkResult = userDao.selectUserByUsername(username);
		String result = "";
		
		if(checkResult == null) {
			result = "x";
		} else {
			result = "ok";
		}
		
		return result;
	}

	public UpdateUserForm memberview(String username) {
		
		User user = userDao.selectUserByUsername(username);

		return UpdateUserForm.fromMember(user);
	}

	public void leaveUser(String username) {
		User user = userDao.selectUserByUsername(username);
		if (user == null) {
			throw new IllegalArgumentException("유저가 없습니다.");
		}
		userDao.deleteUser(username);
	}

	public UpdateUserForm memberListView(String username) {
		User user = userDao.selectUserByUsername(username);
		return UpdateUserForm.fromMember(user);

	}

	public void updateProfileImage(String username, MultipartFile file) throws IllegalStateException, IOException {
		try {
			//1. 사용자 찾기
			User user = userDao.selectUserByUsername(username);
			//2. 이미지 저장
			String filename = saveImage(file);
			//3. 프로필 이미지 주소 변경
			user.setImageName(filename);

			userDao.updateProfileImage(user); }
		catch (Exception e) {

		}
	}
}
