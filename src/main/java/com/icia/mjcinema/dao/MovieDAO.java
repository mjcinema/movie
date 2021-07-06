package com.icia.mjcinema.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mjcinema.domain.Movie;
import com.icia.mjcinema.dto.MovieRegistrationForm;

@Repository
public class MovieDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
			
	public void addmovie(Movie movie) {
		sql.insert("movie.addmovie" , movie);
	}

	public List<Movie> movielist() {		
		return sql.selectList("movie.movielist");
	}

}
