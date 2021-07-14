package com.icia.mjcinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mjcinema.domain.Movie;

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
