package com.icia.mjcinema.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mjcinema.domain.Movie;
import com.icia.mjcinema.dto.MovieRegistrationForm;
import com.icia.mjcinema.service.MovieService;

@RequiredArgsConstructor
@Controller
public class MovieController {
	
	private  final MovieService MovieService;
	
	// 영화 추가화면
	@RequestMapping(value="/Movies/AddMovieForm")
	public String addmovie() {
		return "/Movies/AddMovieForm";
	}
	
	// 영화 예약
	@RequestMapping (value="/Movies/MovieReservation")
	public String moviereservation () {
		return "/movies/MovieReservation";
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
	
	// 영화 목록
	@RequestMapping (value="/Movies/MovieReList")
	public String MovieList(Model model) {
		List<Movie> movies = MovieService.movielist();
		model.addAttribute("movielist" , movies);
		return "/Movies/MovieReList";
	}
	
	
}
