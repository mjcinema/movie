package com.icia.mjcinema.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mjcinema.dto.MovieDTO;

@Repository
public class MovieDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
			
	public void addmovie(MovieDTO movie) {
		sql.insert("movie.addmovie" , movie);
	}

}
