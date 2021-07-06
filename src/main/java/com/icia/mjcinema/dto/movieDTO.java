package com.icia.mjcinema.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class movieDTO {

	private String mcode;
	private String mtitle;
	private String mdirector;
	private String mdate;
	private String mgenre;
	private String mgrade;
	private String mvfilename;
	
	private MultipartFile mvfile;
	
	
}
