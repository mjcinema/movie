package com.icia.mjcinema.service;

import java.io.File;
import java.io.IOException;
import java.util.List;


import com.icia.mjcinema.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.icia.mjcinema.dao.UserDao;
import com.icia.mjcinema.dto.LoginForm;
import com.icia.mjcinema.dto.RegistrationForm;
import com.icia.mjcinema.dto.UpdateUserForm;


@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public User join(RegistrationForm registrationForm) throws IllegalStateException, IOException {

		User user = registrationForm.toUser();

		String imageName = saveImage(registrationForm.getFile());
		user.setImageName(imageName);

		userDao.save(user);
		User joinUser = userDao.getUserByUsername(user.getUsername());
		return joinUser;
		
	}

	private String saveImage(MultipartFile image) throws IllegalStateException, IOException {
		MultipartFile mfile = image;
		String mfilename = mfile.getOriginalFilename();
		mfilename = System.currentTimeMillis() + "-" + mfilename;
		String savePath ="";
		
		if(!mfile.isEmpty()) {
			mfile.transferTo(new File(savePath));
		}
		
		return mfilename;
	}

	public User login(LoginForm loginForm) {
		User user = userDao.getUserByUsername(loginForm.getMid());
		if(user == null || !loginForm.getMpw().equals(user.getPassword())) {
			throw new IllegalStateException("아이디나 비밀번호가 일치하지 않습니다.");
		}
		return user;
		
	}

	public String idCheck(String mid) {
		String checkResult = userDao.idCheck(mid);
		String result = "";
		
		if(checkResult == null) {
			result = "x";
		} else {
			result = "ok";
		}
		
		return result;
	}

	public UpdateUserForm memberview(String mid) {
		
		User user = userDao.memberview(mid);
		// 1. member -> UpdateMemberForm으로 변환
		UpdateUserForm updateUserForm = UpdateUserForm.fromMember(user);
										
		return updateUserForm;
	}

	public List<User> getUsers() {
		List<User> users = userDao.memberlist();
		
		return users;
	}


	public void updateProfileImage(String mid, MultipartFile file) throws IllegalStateException, IOException {
		try {
			//1. 사용자 찾기
			User user = userDao.memberview(mid);
			//2. 이미지 저장
			String filename = saveImage(file);
			//3. 프로필 이미지 주소 변경
			user.setImageName(filename);

			userDao.updateProfileImage(user); }
		catch (Exception e) {

		}
	}


	public UpdateUserForm memberListView(String username) {
		User user = userDao.memberListView(username);
		UpdateUserForm updateUserForm = UpdateUserForm.fromMember(user);
		return updateUserForm;

	}
}
