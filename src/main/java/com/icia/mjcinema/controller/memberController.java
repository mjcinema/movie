package com.icia.mjcinema.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mjcinema.domain.Member;
import com.icia.mjcinema.dto.RegistrationForm;
import com.icia.mjcinema.service.memberService;

@Controller
public class memberController {
	
	@Autowired
	private memberService memberservice;
	
	private ModelAndView mav;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping (value="/Members/Login")
	public String login() {
		return "Members/Login";
	}
	
	@RequestMapping (value="/Members/MemberJoinForm")
	public String joinform() {
		return "Members/MemberJoinForm";
	}
	
	@RequestMapping (value="/Members/memberJoin")
	public ModelAndView memberjoin(@ModelAttribute RegistrationForm registrationForm) throws IllegalStateException, IOException {
		mav = memberservice.memberjoin(registrationForm);
		return mav;
	}
	
	@RequestMapping (value="/Members/memberLogin")
	public ModelAndView memberlogin (@ModelAttribute Member member) {
		mav = memberservice.memberlogin(member);
		return mav;
	}
	
	
		
	@RequestMapping (value="/Members/memberLogout")
	public String logout() {
		session.invalidate();
		return "MovieMain";
	}
	
	@RequestMapping (value="/Members/idCheck")
	public @ResponseBody String idCheck(@RequestParam("mid") String mid) {
		String result = memberservice.idCheck(mid);
		return result;
	}
		
	
	@RequestMapping (value="/Members/memberView")
	public ModelAndView memberview(@RequestParam("mid") String mid) {
		mav = memberservice.memberview(mid);
		return mav;
	}
	
	@RequestMapping (value="/Members/memberlist")
	public ModelAndView memberlist() {
		mav = memberservice.memberlist();
		return mav;
	}
	

	
	
	
	
	
}
