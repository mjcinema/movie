package com.icia.mjcinema.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mjcinema.dao.memberDAO;
import com.icia.mjcinema.dto.Member;

@Service
public class memberService {

	@Autowired
	private memberDAO memberdao;
	
	@Autowired
	private HttpSession session;
	
	private ModelAndView mav;
	
	public ModelAndView memberjoin(Member member) throws IllegalStateException, IOException {
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

	public ModelAndView memberlogin(Member member) {
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

}
