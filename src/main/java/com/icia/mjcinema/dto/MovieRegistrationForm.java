package com.icia.mjcinema.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import com.icia.mjcinema.domain.Movie;

import lombok.Data;

@Getter @Setter
public class MovieRegistrationForm {

	private Long code;
	private String title;
	private String director;
	private String date;
	private String genre;
	private String grade;
	private String fee;
	private String filename;
	
	private MultipartFile file;

	public Movie toMovie() {
		return Movie.builder()
			.title(title)
			.director(director)
			.date(date)
			.genre(genre)
			.grade(grade)
			.fee(fee)
			.build();

	}
}
