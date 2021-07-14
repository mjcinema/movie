package com.icia.mjcinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mjcinema.domain.Movie;

@Mapper
@Repository
public interface MovieMapper {

	List<Movie> getMovies();

	void insertMovie(Movie movie);
}
