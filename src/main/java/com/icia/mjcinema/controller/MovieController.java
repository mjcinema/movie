package com.icia.mjcinema.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.icia.mjcinema.domain.Screening;
import com.icia.mjcinema.dto.UpdateMovieForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.icia.mjcinema.domain.Movie;
import com.icia.mjcinema.dto.MovieRegistrationForm;
import com.icia.mjcinema.service.MovieService;

@RequiredArgsConstructor
@Controller
public class MovieController {
	
	private final MovieService movieService;
	
	// 영화 추가화면
	@RequestMapping(value="/movies/AddMovieForm")
	public String addmovie() {
		return "/movies/AddMovieForm";
	}
	
	// 영화 예약
	@RequestMapping (value="/movies/MovieReservation")
	public String moviereservation () {
		return "/movies/MovieReservation";
	}

	// 영화 예약페이지 영화리스트
	@GetMapping("/movies/MovieReservation")
	public String MovieReservation(Model model) {
		List<Movie> movies = movieService.movielist();
		model.addAttribute("movielist" , movies);
		return "/movies/MovieReservation";
	}





	// 영화 추가
	@PostMapping(value="/movies/new")
	public String addMovie(@ModelAttribute @Valid MovieRegistrationForm joinmovieForm , BindingResult result , HttpSession session) throws IllegalStateException, IOException {
		
		if(result.hasErrors()) {
			return "movies/AddMovieForm";
		}


		Movie movie = movieService.addMovie(joinmovieForm);
		session.setAttribute("joinmovie", movie);
		return "redirect:/";
		
	}


	// 영화 목록
	@GetMapping("/movies")
	public String MovieList(Model model) {
		List<Movie> movies = movieService.movielist();
		model.addAttribute("movielist" , movies);
		return "/movies/MovieReList";
	}

	//영화 정보
	@GetMapping("/movies/{title}")
	public String Movie(@PathVariable("title") String title , Model model){
		UpdateMovieForm movie = movieService.movie(title);
		model.addAttribute("movie" , movie);
		return "movies/MovieInfo";
	}

	// 영화 삭제
	@PostMapping("/movies/{title}/delete")
		public String leaveMovie(@PathVariable("title") String title){
		movieService.leaveMovie(title);
		return "redirect:/";
	}

	//영화 수정 Get
	@GetMapping("/movies/{title}/edit")
	public String movieEditForm(@RequestParam("title")String title , Model model) throws  IllegalStateException, IOException{
		model.addAttribute(title);
		return "/movies/MovieReList";
	}

	//영화 수정 post
	@PostMapping("/movies/{title}/edit")
		public String updateMovie(@PathVariable("title") String title , UpdateMovieForm form , Model model){
		Movie movie = UpdateMovieForm.toMovie(form);
		movieService.updateMovie(movie);
		return  "redirect:/";
	}

	// 홈화면 영화 리스트
	@GetMapping("/views/home")
	public String homeMovieList(Model model) {
		List<Movie> movies = movieService.movielist();
		model.addAttribute("movie" , movies);
		return "/views/home";
	}

}
