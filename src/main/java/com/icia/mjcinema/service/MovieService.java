package com.icia.mjcinema.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.mjcinema.dao.MovieDAO;
import com.icia.mjcinema.domain.Movie;
import com.icia.mjcinema.dto.MovieRegistrationForm;

@Service
public class MovieService {

	@Autowired
	private MovieDAO Moviedao;
		
	public Movie addmovie(MovieRegistrationForm movieRegistrationForm) throws IllegalStateException, IOException {
		
		String filename = uploadImage(movieRegistrationForm.getMvfile());
		
		Movie movie = new Movie();
		movie.setMcode(movieRegistrationForm.getMcode());
		movie.setMtitle(movieRegistrationForm.getMtitle());
		movie.setMdirector(movieRegistrationForm.getMdirector());
		movie.setMdate(movieRegistrationForm.getMdate());
		movie.setMgenre(movieRegistrationForm.getMgenre());
		movie.setMgrade(movieRegistrationForm.getMgrade());
		
		movie.setMvfilename(filename);
		
		Moviedao.addmovie(movie);
		
		return movie;

		}
	
	private String uploadImage(MultipartFile image) throws IllegalStateException, IOException {
		MultipartFile mfile = image;
		String mvfilename = mfile.getOriginalFilename();
		mvfilename = System.currentTimeMillis() + "-" + mvfilename;
		String savePath = "D:\\source_BJH\\spring\\mjcinema\\src\\main\\webapp\\resources\\img\\mvPoster\\" + mvfilename;
		
		if(!mfile.isEmpty()) {
			mfile.transferTo(new File(savePath));
		}
		
		return mvfilename;
	}

	public List<Movie> movielist() {
		List<Movie> movies = Moviedao.movielist();
		return movies;
	}
	

}
