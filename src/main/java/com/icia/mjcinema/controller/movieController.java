package com.icia.mjcinema.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mjcinema.dto.movieDTO;
import com.icia.mjcinema.service.movieService;

@Controller
public class movieController {
	
	@Autowired
	private movieService movieservice;
	
	private ModelAndView mav;
	
	// 영화 추가화면
	@RequestMapping(value="/Movies/AddMovieForm")
	public String addmovie() {
		return "/Movies/AddMovieForm";
	}
	
	// 영화 예약
	@RequestMapping (value="/Movies/MovieReservation")
	public String moviereservation () {
		return "/Movies/MovieReservation";
	}
	
	// 영화 추가
	@RequestMapping (value="/Movies/addMovie")
	public ModelAndView addmovie(@ModelAttribute movieDTO movie) throws IllegalStateException, IOException {
		mav = movieservice.addmovie(movie);
	return mav;
	}
	
	
}
