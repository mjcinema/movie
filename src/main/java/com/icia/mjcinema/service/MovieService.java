package com.icia.mjcinema.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.icia.mjcinema.dto.UpdateMovieForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.icia.mjcinema.mapper.MovieMapper;
import com.icia.mjcinema.domain.Movie;
import com.icia.mjcinema.dto.MovieRegistrationForm;

@RequiredArgsConstructor
@Service
@Transactional
public class MovieService {

	private final MovieMapper movieMapper;
		
	public Movie addMovie(MovieRegistrationForm movieRegistrationForm)  {
		Movie movie = movieRegistrationForm.toMovie();
		movieMapper.insertMovie(movie);
		return movieMapper.getMovieByCode(movie.getCode());

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
		return movieMapper.getMovies();
	}


	public UpdateMovieForm movie(String title) {

		Movie movie = movieMapper.getMovieByTitle(title);

		return UpdateMovieForm.fromMovie(movie);

	}

	public void leaveMovie(String title) {
		Movie movie = movieMapper.getMovieByTitle(title);
		if(movie == null){
			throw new IllegalArgumentException("영화가 없습니다.");
		}
		movieMapper.deleteMovie(title);

	}

    public void updateMovie(Movie movie) {
		movieMapper.updateMovie(movie);
    }
}
