package com.icia.mjcinema.dto;

import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JoinMemberForm {
	
	@NotEmpty(message="id를 입력해주세요")
	private String mid;
	private String mname;
	private String mpw;
	private String mbirth;
	private String memail;
	private String maddr;
	private String mfilename;
	
	private MultipartFile mfile;
}
