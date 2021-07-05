package com.icia.mjcinema.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mjcinema.dao.memberDAO;
import com.icia.mjcinema.dto.memberDTO;
import com.icia.mjcinema.dto.pageDTO;

@Service
public class memberService {

	@Autowired
	private memberDAO memberdao;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav;
	
	public ModelAndView memberjoin(memberDTO member) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		MultipartFile mfile = member.getMfile();
		String mfilename = mfile.getOriginalFilename();
		mfilename = System.currentTimeMillis() + "-" + mfilename;
		String savePath = "D:\\source_BJH\\spring\\mjcinema\\src\\main\\webapp\\WEB-INF\\views\\img\\memProfile\\" + mfilename;
		
		if(!mfile.isEmpty()) {
			mfile.transferTo(new File(savePath));
		}
		
		member.setMfilename(mfilename);
		memberdao.memberjoin(member);
		mav.setViewName("redirect:/.");
		
		return mav;
	}

	public ModelAndView memberlogin(memberDTO member) {
		mav = new ModelAndView();
		String loginId = memberdao.memberlogin(member);
		
		if(loginId != null) {
			session.setAttribute("loginMember", loginId);
			mav.setViewName("redirect:/.");
		} else {
			mav.setViewName("memberlogin");
		}
		
		return mav;
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
		memberDTO member = memberdao.memberview(mid);
		mav.addObject("member" , member);
		mav.setViewName("/Members/MemberView");
		return mav;
	}

	public ModelAndView memberlist() {
		mav = new ModelAndView();
		List<memberDTO> member = memberdao.memberlist();
		mav.addObject("memberlist", member);
		mav.setViewName("/Members/memberlist");
		return mav;
	}
	
	
	

}
