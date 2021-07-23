package com.icia.mjcinema.dto;


import com.icia.mjcinema.controller.MovieController;
import com.icia.mjcinema.domain.Movie;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UpdateMovieForm {

    public static MovieController fromMovie;
    private String title;
    private String director;
    private String date;
    private String genre;
    private String grade;
    private String fee;
    private String filename;

    private MultipartFile file;

    public static UpdateMovieForm fromMovie(Movie movie){
        UpdateMovieForm form = new UpdateMovieForm();
        form.setTitle(movie.getTitle());
        form.setDirector(movie.getDirector());
        form.setDate(movie.getDate());
        form.setGenre(movie.getGenre());
        form.setGrade(movie.getGrade());
        form.setFee(movie.getFee());
        form.setFilename(movie.getFileName());
        return form;

    }
    public static Movie toMovie(UpdateMovieForm form){
        Movie movie = new Movie();
        movie.setTitle(form.getTitle());
        movie.setDirector(form.getDirector());
        movie.setDate(form.getDate());
        movie.setGenre(form.getGenre());
        movie.setGrade(form.getGrade());
        movie.setFee(form.getFee());
        movie.setFileName(form.getFilename());
        return movie;
    }


}
