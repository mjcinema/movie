package com.icia.mjcinema.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.icia.mjcinema.domain.Member;
import com.icia.mjcinema.dto.LoginForm;
import com.icia.mjcinema.dto.RegistrationForm;
import com.icia.mjcinema.service.MemberService;

@Controller
public class memberController {
	
	@Autowired
	private MemberService memberservice;
	
	
	
	@RequestMapping (value="/Members/Login")
	public String login() {
		return "Members/Login";
	}
	
	@RequestMapping (value="/Members/MemberJoinForm")
	public String joinform() {
		return "Members/MemberJoinForm";
	}
	
	@RequestMapping (value="/Members/memberJoin")
	public String memberjoin(@ModelAttribute @Valid RegistrationForm registrationForm , BindingResult result , HttpSession session) throws IllegalStateException, IOException {
		if (result.hasErrors()) {
			return "Member/MemberJoinForm";
		}
		Member member = memberservice.memberjoin(registrationForm);
		session.setAttribute("loginMember", member);
		return "redirect:/";
		
	}
	
	@RequestMapping (value="/Members/memberLogin")
	public String memberlogin (@ModelAttribute LoginForm loginForm , BindingResult result , HttpSession session) {
		Member member;
		
		try {
			member = memberservice.memberlogin(loginForm);
		} catch (RuntimeException e) {
			FieldError fieldError = new FieldError("loginForm" , "invalidIdOrPassword" , e.getMessage());
			result.addError(fieldError);
			return "Member/Login";
		}
		
		session.setAttribute("loginMember", member);
		return "redirect:/";
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
