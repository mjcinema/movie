package com.icia.mjcinema.service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mjcinema.dao.movieDAO;
import com.icia.mjcinema.dto.movieDTO;

@Service
public class movieService {

	@Autowired
	private movieDAO moviedao;
	
	private ModelAndView mav;
	
	public ModelAndView addmovie(movieDTO movie) throws IllegalStateException, IOException {
		mav = new ModelAndView();
		MultipartFile mvfile = movie.getMvfile();
		String mvfilename = mvfile.getOriginalFilename();
		mvfilename = System.currentTimeMillis() + "-" + mvfilename;
		String savePath = "D:\\source_BJH\\spring\\mjcinema\\src\\main\\webapp\\WEB-INF\\views\\img\\mvPoster" + mvfilename;
		
		if(!mvfile.isEmpty()) {
			mvfile.transferTo(new File(savePath));
		}
		
		movie.setMvfilename(mvfilename);
		moviedao.addmovie(movie);
		mav.setViewName("MovieMain");
		
		return mav;
	}

}
