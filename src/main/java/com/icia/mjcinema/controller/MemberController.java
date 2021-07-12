package com.icia.mjcinema.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import com.icia.mjcinema.dto.LoginForm;
import com.icia.mjcinema.dto.RegistrationForm;
import com.icia.mjcinema.dto.UpdateMemberForm;
import com.icia.mjcinema.service.MemberService;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping (value="/Members/Login")
	public String login() {
		return "login/Login";
	}
	
	@RequestMapping (value="/Members/MemberJoinForm")
	public String joinform() {
		return "Members/MemberJoinForm";
	}
	
	@RequestMapping (value="/Members/memberJoin")
	public String memberjoin(@ModelAttribute @Valid RegistrationForm joinMemberForm, BindingResult result, HttpSession session) throws IllegalStateException, IOException {
		
		if (result.hasErrors()) {
			
			return "Members/MemberJoinForm";
		}
		Member member = memberservice.memberjoin(joinMemberForm);
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
			return "login/Login";
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
	public @ResponseBody String idCheck(@RequestParam("mid") String username) {
		String result = memberservice.idCheck(username);
		return result;
	}
		
	
	@RequestMapping (value="/Members/memberView")
	public String memberview(@RequestParam("mid") String mid , Model model) {
		UpdateMemberForm member = memberservice.memberview(mid);
		model.addAttribute("member", member);
		
		return "Members/MemberView";
	}
	
	@RequestMapping (value="/Members/memberlist")
	public String memberlist(Model model) {
		List<Member> members = memberservice.memberlist();
		model.addAttribute("memberlist", members);
		return "Members/memberlist";
	}

	@RequestMapping (value="/Members/modifyMemberProfile" )
	public String profileModify(@RequestParam("mid") String mid, @RequestParam("mfile") MultipartFile mfile, Model model) throws IllegalStateException, IOException {

		memberservice.updateProfileImage(mid, mfile);
		model.addAttribute("mid", mid);
		model.addAttribute("mfile", mfile);
		return "redirect:/Members/memberView";
	}
	
	
	
	
	
}
