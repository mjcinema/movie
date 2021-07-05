package com.icia.mjcinema.service;

import java.io.File;
import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.icia.mjcinema.dao.memberDAO;
import com.icia.mjcinema.domain.Member;
import com.icia.mjcinema.dto.JoinMemberForm;
import com.icia.mjcinema.dto.LoginForm;

@Service
public class memberService {

	@Autowired
	private memberDAO memberdao;
	

	public Member memberjoin(JoinMemberForm dto) throws IllegalStateException, IOException {
		
		String filename = uploadImage(dto.getMfile());
		
		Member member = new Member();
		member.setMid(dto.getMid());
		member.setMname(dto.getMname());
		member.setMpw(dto.getMpw());
		member.setMbirth(dto.getMbirth());
		member.setMemail(dto.getMemail());
		member.setMaddr(dto.getMaddr());
		
		member.setMfilename(filename);
		
		memberdao.memberjoin(member);
		Member joinedUser = memberdao.memberlogin(member.getMid());
		return joinedUser;
	}
	
	private String uploadImage(MultipartFile image) throws IllegalStateException, IOException {
		MultipartFile mfile = image;
		String mfilename = mfile.getOriginalFilename();
		mfilename = System.currentTimeMillis() + "-" + mfilename;
		String savePath = "C:\\Users\\LeeMinYong\\git\\movie\\src\\main\\webapp\\WEB-INF\\views\\img\\memProfile\\" + mfilename;
		
		if(!mfile.isEmpty()) {
			mfile.transferTo(new File(savePath));
		}
		
		return mfilename;
	}
	
	// Spring-validation
	public Member memberlogin(LoginForm loginForm) {
		Member member = memberdao.memberlogin(loginForm.getMid());
		if(member == null || !loginForm.getMpw().equals(member.getMpw())) {
			throw new IllegalStateException("아이디나 비밀번호가 일치하지 않습니다.");
		}
		
		return member;
	}

	public String idCheck(String mid) {
		String checkResult = memberdao.idCheck(mid);
		String result = "";
		
		if(checkResult == null) {
			result = "x";
		} else {
			result = "ok";
		}
		
		return result;
	}

}
