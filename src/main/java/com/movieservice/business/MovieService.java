package com.movieservice.business;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.movieservice.dao.MovieDao;
import com.movieservice.dao.impl.MovieDaoImpl;
import com.movieservice.model.Movie;
import com.movieservice.model.Response;

@Path("movie")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieService {

	private static MovieDao movieDao = new MovieDaoImpl();

	@POST
	@Path("/add")
	public Response addMovie(Movie movie) {

		Response response = movieDao.addMovie(movie);

		return response;
	}

	@GET
	@Path("/getAllMovies")
	public List<Movie> getAllMovies() {

		List<Movie> movies = movieDao.getAllMovies();

		return movies;
	}

	@GET
	@Path("/title/{title}")
	public Movie getMovieByTitle(@PathParam("title") String title) {

		Movie movie = movieDao.getMovieByTitle(title);

		return movie;
	}

	@GET
	@Path("/id/{id}")
	public Movie getMovieById(@PathParam("id") String id) {

		Movie movie = movieDao.getMovieById(id);

		return movie;
	}

	@GET
	@Path("/cast/{cast}")
	public List<Movie> getMoviesbyCast(@PathParam("cast") String cast) {

		List<Movie> movies = movieDao.getMoviesByCast(cast);

		return movies;
	}

	@GET
	@Path("/genre/{genre}")
	public List<Movie> getMoviesByGenre(@PathParam("genre") String genre) {

		List<Movie> movies = movieDao.getMoviesByGenre(genre);

		return movies;
	}

	@GET
	@Path("/year/{year}")
	public List<Movie> getMoviesByYear(@PathParam("year") String year) {

		List<Movie> movies = movieDao.getMoviesByYear(year);

		return movies;
	}

	@GET
	@Path("/rating/{rating}")
	public List<Movie> getMoviesByRating(@PathParam("rating") Double rating) {

		List<Movie> movies = movieDao.getMoviesByRating(rating);

		return movies;
	}

	@GET
	@Path("/album/{album}")
	public List<Movie> getMoviesByAlbum(@PathParam("album") String album) {

		List<Movie> movies = movieDao.getMoviesByAlbum(album);

		return movies;
	}

	@GET
	@Path("/production/{production}")
	public List<Movie> getMoviesByProductionHouse(@PathParam("production") String productionHouse) {

		List<Movie> movies = movieDao.getMoviesByProductionHouse(productionHouse);

		return movies;
	}

	@GET
	@Path("/delete/{title}")
	public Response deleteMovieByTitle(@PathParam("title") String title) {

		Response response = movieDao.deleteMovie(title);

		return response;
	}
}