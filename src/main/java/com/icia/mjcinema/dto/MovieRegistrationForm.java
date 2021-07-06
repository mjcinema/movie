package com.icia.mjcinema.dto;

import org.springframework.web.multipart.MultipartFile;

import com.icia.mjcinema.domain.Member;
import com.icia.mjcinema.domain.Movie;

import lombok.Data;

@Data
public class MovieRegistrationForm {

	private String mcode;
	private String mtitle;
	private String mdirector;
	private String mdate;
	private String mgenre;
	private String mgrade;
	private String mvfilename;
	
	private MultipartFile mvfile;
	
	public Movie toMovie() {
		Movie movie = new Movie();
		movie.setMcode(mcode);
		movie.setMtitle(mtitle);
		movie.setMdirector(mdirector);
		movie.setMdate(mdate);
		movie.setMgenre(mgenre);
		movie.setMgrade(mgrade);
		movie.setMvfilename(mvfilename);
		return movie;
	}
}
