package com.icia.mjcinema.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JoinMemberForm {
	private String mid;
	private String mname;
	private String mpw;
	private String mbirth;
	private String memail;
	private String maddr;
	private String mfilename;
	
	private MultipartFile mfile;
}
