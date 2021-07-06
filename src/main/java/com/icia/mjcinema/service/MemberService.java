package com.icia.mjcinema.service;

import java.io.File;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.icia.mjcinema.dao.memberDAO;
import com.icia.mjcinema.domain.Member;
import com.icia.mjcinema.dto.LoginForm;
import com.icia.mjcinema.dto.RegistrationForm;
import com.icia.mjcinema.dto.UpdateMemberForm;
import com.icia.mjcinema.dto.pageDTO;

@Service
public class MemberService {

	@Autowired
	private memberDAO memberdao;
	

	
	public Member memberjoin(RegistrationForm registrationForm) throws IllegalStateException, IOException {
		
		String filename = uploadImage(registrationForm.getMfile());

		Member member = new Member();
		member.setMid(registrationForm.getMid());
		member.setMpw(registrationForm.getMpw());
		member.setMname(registrationForm.getMname());
		member.setMbirth(registrationForm.getMbirth());
		member.setMemail(registrationForm.getMemail());
		member.setMaddr(registrationForm.getMaddr());
		
		member.setMfilename(filename);
		
		memberdao.memberjoin(member);
		Member joinUser = memberdao.memberlogin(member.getMid());
		return joinUser;
		
	}

	private String uploadImage(MultipartFile image) throws IllegalStateException, IOException {
		MultipartFile mfile = image;
		String mfilename = mfile.getOriginalFilename();
		mfilename = System.currentTimeMillis() + "-" + mfilename;
		String savePath = "D:\\source_BJH\\spring\\mjcinema\\src\\main\\webapp\\WEB-INF\\views\\img\\memProfile\\" + mfilename;
		
		if(!mfile.isEmpty()) {
			mfile.transferTo(new File(savePath));
		}
		
		return mfilename;
	}

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

	public UpdateMemberForm memberview(String mid) {
		
		Member member = memberdao.memberview(mid);
		// 1. member -> UpdateMemberForm으로 변환
		UpdateMemberForm updateMemberForm = UpdateMemberForm.fromMember(member);
										
		return updateMemberForm;
	}

	public List<Member> memberlist() {
		List<Member> members = memberdao.memberlist();
		
		return members;
	}
	
	
	

}
