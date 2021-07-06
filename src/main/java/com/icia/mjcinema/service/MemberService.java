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
		
		memberdao.memberjoin(member);
		Member joinUser = memberdao.memberlogin(member.getMid());
		return joinUser;
		
	}

	private String uploadImage(MultipartFile mfile) {
		// TODO Auto-generated method stub
		return null;
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

	public ModelAndView memberview(String mid) {
		mav = new ModelAndView();
		Member member = memberdao.memberview(mid);
		// 1. member -> UpdateMemberForm으로 변환
		UpdateMemberForm updateMemberForm = UpdateMemberForm.fromMember(member);
		// 2. UpdateMemberForm을 모델에 담기
		mav.addObject("member" , updateMemberForm);
		mav.setViewName("/Members/MemberView");
		return mav;
	}

	public ModelAndView memberlist() {
		mav = new ModelAndView();
		List<Member> member = memberdao.memberlist();
		mav.addObject("memberlist", member);
		mav.setViewName("/Members/memberlist");
		return mav;
	}
	
	
	

}
