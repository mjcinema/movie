package com.icia.mjcinema.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Member {

//	MID => 회원아이디 
//			MPW => 비밀번호
//			MNAME=> 회원이름
//			MBIRTH => 생년월일
//			MEMAIL => 이메일
//			MADDR => 주소
//			MPROFILE => 프로필이미지
	
	private String mid;
	private String mname;
	private String mpw;
	private String mbirth;
	private String memail;
	private String maddr;
	private String mfilename;
	
	private MultipartFile mfile;
	
	
	
}
