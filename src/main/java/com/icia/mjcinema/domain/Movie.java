package com.icia.mjcinema.domain;

import lombok.*;


@NoArgsConstructor
@Getter @Setter
public class Movie {

	private Long code;
	private String title;
	private String director;
	private String date;
	private String genre;
	private String grade;
	private String fileName;
	private String fee;
	
	@Builder
	public Movie(Long code, String title, String director, String date, String genre, String grade,  String fee) {
		this.code = code;
		this.title = title;
		this.director = director;
		this.date = date;
		this.genre = genre;
		this.grade = grade;
		this.fee = fee;
	}
}
