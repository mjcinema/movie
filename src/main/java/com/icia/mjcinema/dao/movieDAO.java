package com.icia.mjcinema.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mjcinema.dto.movieDTO;

@Repository
public class movieDAO {
	
	@Autowired
	private SqlSessionTemplate sql;
			
	public void addmovie(movieDTO movie) {
		sql.insert("movie.addmovie" , movie);
	}

}
