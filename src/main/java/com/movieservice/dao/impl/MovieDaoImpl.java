
package com.movieservice.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.movieservice.dao.MovieDao;
import com.movieservice.model.Movie;
import com.movieservice.model.Response;
import com.movieservice.util.MongodbConnection;


public class MovieDaoImpl implements MovieDao {
	
	@Override
	public Response addMovie(Movie movie) {
		
		Response response = new Response();
		
		try {
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			JSONObject movieJSON = new JSONObject(movie);
			Document document = new Document();
			
			Iterator<String> keys = movieJSON.keySet().iterator();
			
			while (keys.hasNext()) {
				String key = keys.next();
				document.put(key, movieJSON.get(key));
			}
			
			collection.insertOne(document);
			
			response.setStatus(true);
			response.setMessage("Movie stored successfully");
			response.setId(movie.getId());
			response.setTitle(movie.getTitle());
			
		} catch (Exception e) {
			
			response.setStatus(false);
			response.setMessage("Unable to insert movie details because " + e.getMessage());
			response.setId(movie.getId());
			response.setTitle(movie.getTitle());
			e.printStackTrace();
		}
		
		return response;
	}
	
	@Override
	public List<Movie> getAllMovies() {
		
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			FindIterable<Document> iterable = collection.find();
			
			Iterator<Document> itr = iterable.iterator();
			
			while(itr.hasNext()) {
				
				Document doc = itr.next();
				
				Movie movie = docToMovie(doc);
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return movies;
	}
	
	@Override
	public Movie getMovieByTitle(String title) {
		
		Movie movie = new Movie();
		
		try {
			
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			BasicDBObject query = new BasicDBObject();
			query.put("title", title);
			
			FindIterable<Document> iterable = collection.find(query);
			
			Iterator<Document> itr = iterable.iterator();
			
			movie = docToMovie(itr.next());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	@Override
	public Movie getMovieById(String id) {
		
		Movie movie = new Movie();
		
		try {
			
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			BasicDBObject query = new BasicDBObject();
			query.put("id", id);
			
			FindIterable<Document> iterable = collection.find(query);
			
			Iterator<Document> itr = iterable.iterator();
			
			movie = docToMovie(itr.next());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	@Override
	public List<Movie> getMoviesByCast(String cast) {
		
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			BasicDBObject query = new BasicDBObject();
			query.put("cast", cast);
			
			FindIterable<Document> iterable = collection.find(query);
			
			Iterator<Document> itr = iterable.iterator();
			
			while (itr.hasNext()) {
				
				Movie movie = docToMovie(itr.next());
				
				movies.add(movie);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return movies;
	}
	
	@Override
	public List<Movie> getMoviesByGenre(String genre) {
		
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			BasicDBObject query = new BasicDBObject();
			query.put("genre", genre);
			
			FindIterable<Document> iterable = collection.find(query);
			
			Iterator<Document> itr = iterable.iterator();
			
			while (itr.hasNext()) {
				
				Movie movie = docToMovie(itr.next());
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return movies;
	}
	
	@Override
	public List<Movie> getMoviesByYear(String year) {
		
		List<Movie> movies = new ArrayList<>();
		
		try {
			
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			BasicDBObject query = new BasicDBObject();
			query.put("year", year);
			
			FindIterable<Document> iterable = collection.find(query);
			
			Iterator<Document> itr = iterable.iterator();
			
			while (itr.hasNext()) {
				
				Movie movie = docToMovie(itr.next());
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return movies;
	}

	@Override
	public List<Movie> getMoviesByRating(Double rating) {
		
		List<Movie> movies = new ArrayList<>();
		
		try {
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			BasicDBObject query = new BasicDBObject();
			query.put("rating", rating.toString());
			
			FindIterable<Document> iterable = collection.find(query);
			
			Iterator<Document> itr = iterable.iterator();
			
			while (itr.hasNext()) {
				
				Movie movie = docToMovie(itr.next());
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return movies;
	}

	@Override
	public List<Movie> getMoviesByAlbum(String album) {
		
		List<Movie> movies = new ArrayList<>();
		
		try {
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			BasicDBObject query = new BasicDBObject();
			query.put("album", album);
			
			FindIterable<Document> iterable = collection.find(query);
			
			Iterator<Document> itr = iterable.iterator();
			
			while (itr.hasNext()) {
				
				Movie movie = docToMovie(itr.next());
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return movies;
	}
	
	@Override
	public List<Movie> getMoviesByProductionHouse(String productionHouse) {
		
		List<Movie> movies = new ArrayList<>();
		
		try {
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			BasicDBObject query = new BasicDBObject();
			query.put("productionHouse", productionHouse);
			
			FindIterable<Document> iterable = collection.find(query);
			
			Iterator<Document> itr = iterable.iterator();
			
			while (itr.hasNext()) {
				
				Movie movie = docToMovie(itr.next());
				
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movies;
	}

	@Override
	public Response deleteMovie(String title) {
		
		Response response = new Response();
		
		try {
			
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			collection.deleteOne(Filters.eq("title", title));
			
			response.setStatus(true);
			response.setMessage("Successfully deleted movie details");
			response.setTitle(title);
						
		} catch (Exception e) {
			
			response.setStatus(false);
			response.setMessage("Unable to delete movie details because " + e.getMessage());
			response.setTitle(title);
			e.printStackTrace();
		}
		return response;
	}
	
	@Override
	public Response deleteMovie(Integer id) {
		
		Response response = new Response();
		
		try {
			
			MongoCollection<Document> collection = MongodbConnection.getMongoCollection();
			
			collection.deleteOne(Filters.eq("id", id.toString()));
			
			response.setStatus(true);
			response.setMessage("Successfully deleted movie details");
			response.setId(id.toString());
			
		} catch (Exception e) {
			
			response.setStatus(false);
			response.setMessage("Unable to insert movie details because " + e.getMessage());
			response.setId(id.toString());
			e.printStackTrace();
		}
		return response;
	}
	
	
	private Movie docToMovie(Document doc) {
		
		Movie movie = new Movie();
		
		movie.setId(doc.getString("id"));
		movie.setTitle(doc.getString("title"));
		movie.setAlbum(doc.getString("album"));
		movie.setCast((List<String>) doc.get("cast"));
		movie.setGenre((List<String>)doc.get("genre"));
		movie.setProductionHouse(doc.getString("productionHouse"));
		movie.setRating(doc.getString("rating"));
		movie.setYear(doc.getString("year"));
		
		return movie;
	}

}