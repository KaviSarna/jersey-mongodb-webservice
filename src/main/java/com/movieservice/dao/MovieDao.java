package com.movieservice.dao;

import java.util.List;

import com.movieservice.model.Movie;
import com.movieservice.model.Response;

public interface MovieDao {
	
	public Response addMovie(Movie movie);
	
	public List<Movie> getAllMovies();
	
	public Movie getMovieByTitle(String title);
	
	public Movie getMovieById(String id);
	
	public List<Movie> getMoviesByCast(String cast);
	
	public List<Movie> getMoviesByGenre(String genre);
	
	public List<Movie> getMoviesByYear(String year);
	
	public List<Movie> getMoviesByRating(Double rating);
	
	public List<Movie> getMoviesByAlbum(String album);
	
	public List<Movie> getMoviesByProductionHouse(String productionHouse);
	
	public Response deleteMovie(String title);
	
	public Response deleteMovie(Integer id);
}