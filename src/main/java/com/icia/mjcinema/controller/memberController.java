package com.icia.mjcinema.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mjcinema.dto.memberDTO;
import com.icia.mjcinema.service.memberService;

@Controller
public class memberController {
	
	@Autowired
	private memberService memberservice;
	
	private ModelAndView mav;
	
	@RequestMapping (value="/Members/Login")
	public String login() {
		return "Members/Login";
	}
	
	@RequestMapping (value="/Members/MemberJoinForm")
	public String joinform() {
		return "Members/MemberJoinForm";
	}
	
	@RequestMapping (value="/Members/memberJoin")
	public ModelAndView memberjoin(@ModelAttribute memberDTO member) throws IllegalStateException, IOException {
		mav = memberservice.memberjoin(member);
		return mav;
	}
	
	@RequestMapping (value="/Members/memberLogin")
	public ModelAndView memberlogin (@ModelAttribute memberDTO member) {
		mav = memberservice.memberlogin(member);
		return mav;
	}
	
	@RequestMapping (value="/Members/memberView")
	public String memberview() {
		return "/Members/memberView";
	}
		
	
	
}
