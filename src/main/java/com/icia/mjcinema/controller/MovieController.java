package com.icia.mjcinema.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mjcinema.domain.Movie;
import com.icia.mjcinema.dto.MovieRegistrationForm;
import com.icia.mjcinema.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService MovieService;
	
	
	
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
	public String addMovie(@ModelAttribute @Valid MovieRegistrationForm joinmovieForm , BindingResult result , HttpSession session) throws IllegalStateException, IOException {
		
		if(result.hasErrors()) {
			return "Movies/AddMovieForm";
		}
		
		Movie movie = MovieService.addmovie(joinmovieForm);
		session.setAttribute("joinmovie", movie);
		return "redirect:/";
		
	}
	
	
}
