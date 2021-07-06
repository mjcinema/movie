package com.icia.mjcinema.dto;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import com.icia.mjcinema.domain.Member;

import lombok.Data;

@Data
public class RegistrationForm {
	
	@NotEmpty(message="id를 입력해주세요")
	private String mid;
	private String mname;
	private String mpw;
	private String mbirth;
	private String memail;
	private String maddr;
	private String mfilename;

	private MultipartFile mfile;
	
	public Member toMember() {
		Member member = new Member();
		member.setMid(mid);
		member.setMname(mname);
		member.setMpw(mpw);
		member.setMbirth(mbirth);
		member.setMemail(memail);
		member.setMaddr(maddr);
		member.setMfilename(mfilename);
		return member;
	}
}
