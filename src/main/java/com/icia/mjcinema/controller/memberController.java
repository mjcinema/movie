package com.icia.mjcinema.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.mjcinema.domain.Member;
import com.icia.mjcinema.dto.JoinMemberForm;
import com.icia.mjcinema.dto.LoginForm;
import com.icia.mjcinema.service.memberService;

@Controller
public class memberController {
	
	private static final Logger log = LoggerFactory.getLogger(memberController.class);
	
	@Autowired
	private memberService memberservice;
	
	@RequestMapping (value="/Members/Login")
	public String login() {
		return "Members/Login";
	}
	
	@RequestMapping (value="/Members/MemberJoinForm")
	public String joinform() {
		return "Members/MemberJoinForm";
	}
	
	@RequestMapping (value="/Members/memberJoin")
	public String memberjoin(@ModelAttribute @Valid JoinMemberForm joinMemberForm, HttpSession session, BindingResult result) throws IllegalStateException, IOException {
		if (result.hasErrors()) {
			return "Members/MemberJoinForm";
		}
		Member member = memberservice.memberjoin(joinMemberForm);
		session.setAttribute("loginMember", member);
		return "redirect:/";
	}
	
	@RequestMapping (value="/Members/memberLogin")
	public String memberlogin (@ModelAttribute LoginForm loginForm, HttpSession session, BindingResult result) {
		Member member;
		
		try {
			member = memberservice.memberlogin(loginForm);
		} catch (RuntimeException e){
			FieldError fieldError = new FieldError("loginForm", "invalidIdOrPassword", e.getMessage());
			result.addError(fieldError);
			return "Members/Login";
		}
		
		session.setAttribute("loginMember", member);
		return "redirect:/";
	}
	
	@RequestMapping (value="/Members/memberView")
	public String memberview() {
		return "/Members/MemberView";
	}
		
	@RequestMapping (value="/Members/memberLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "MovieMain";
	}
	
	@RequestMapping (value="/Members/idCheck")
	public @ResponseBody String idCheck(@RequestParam("mid") String mid) {
		String result = memberservice.idCheck(mid);
		return result;
	}

	
}
