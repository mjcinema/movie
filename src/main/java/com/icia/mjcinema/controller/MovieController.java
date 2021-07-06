package com.icia.mjcinema.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mjcinema.dto.MovieDTO;
import com.icia.mjcinema.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieservice;
	
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
	public ModelAndView addmovie(@ModelAttribute MovieDTO movie) throws IllegalStateException, IOException {
		mav = movieservice.addmovie(movie);
	return mav;
	}
	
	
}
