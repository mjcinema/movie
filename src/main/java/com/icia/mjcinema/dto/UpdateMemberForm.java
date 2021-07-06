package com.icia.mjcinema.dto;

import org.springframework.web.multipart.MultipartFile;

import com.icia.mjcinema.domain.Member;

import lombok.Data;


@Data
public class UpdateMemberForm {
	
	private String mid;
	private String mname;
	private String mpw;
	private String mbirth;
	private String memail;
	private String maddr;
	private String mfilename;

	private MultipartFile mfile;
	
	public static UpdateMemberForm fromMember(Member member) {
		UpdateMemberForm form = new UpdateMemberForm();
		form.setMid(member.getMid());
		form.setMname(member.getMname());
		form.setMpw(member.getMpw());
		form.setMbirth(member.getMbirth());
		form.setMaddr(member.getMaddr());
		form.setMemail(member.getMemail());
		form.setMfilename(member.getMfilename());
		
		return form;
	}
}
