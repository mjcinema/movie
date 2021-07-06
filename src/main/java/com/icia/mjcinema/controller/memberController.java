package com.icia.mjcinema.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.mjcinema.domain.Member;
import com.icia.mjcinema.dto.RegistrationForm;
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
	public String joinform(Model model) {
		log.debug("member joinForm!!!시발 좇같당.앙ㄹ머ㅏㅇㄻㄹㅇㅁ!!");
		model.addAttribute("joinMemberForm", new RegistrationForm());
		return "Members/MemberJoinForm";
	}
	
	@RequestMapping (value="/Members/memberJoin")
	public String memberjoin(@ModelAttribute @Valid RegistrationForm joinMemberForm, BindingResult result, HttpSession session) throws IllegalStateException, IOException {
		log.debug("member join!!!시발 좇같당.앙ㄹ머ㅏㅇㄻㄹㅇㅁ!!");
		if (result.hasErrors()) {
			log.debug("시발 좇같당.앙ㄹ머ㅏㅇㄻㄹㅇㅁ");
			return "Members/MemberJoinForm";
		}
		Member member = memberservice.memberjoin(joinMemberForm);
		session.setAttribute("loginMember", member);
		return "redirect:/";
	}
	
	@RequestMapping (value="/Members/memberLogin")
	public String memberlogin (@ModelAttribute LoginForm loginForm, BindingResult result, HttpSession session) {
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
