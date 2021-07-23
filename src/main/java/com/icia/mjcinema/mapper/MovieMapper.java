package com.icia.mjcinema.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.icia.mjcinema.domain.Movie;

@Mapper
@Repository
public interface MovieMapper {
    List<Movie> getMovies();
    Movie getMovieByCode(Long code);
    Movie getMovieByTitle(String title);

	void insertMovie(Movie movie);
    void deleteMovie(String title);
    void updateMovie(Movie movie);
}
