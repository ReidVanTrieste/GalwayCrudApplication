package com.vantrieste.CRUDApplication.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vantrieste.CRUDApplication.model.Movie;
import com.vantrieste.CRUDApplication.repo.MovieRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class MovieController {

	@Autowired
	private MovieRepo movieRepo;

	@GetMapping("/getAllMovies")
	public ResponseEntity<List<Movie>> getAllMovies() {
		try {
			List<Movie> movieList = new ArrayList<>();
			movieRepo.findAll().forEach(movieList::add);

			if (movieList.isEmpty()) {
				return new ResponseEntity<>( HttpStatus.NO_CONTENT);

			}
			return new ResponseEntity<>(movieList, HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getMovieById/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long id){

		Optional<Movie> movieData = movieRepo.findById(id);

		if (movieData.isPresent()) {
			return new ResponseEntity<>(movieData.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	 @PostMapping("/addMovie")
	    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
	        try {
	        	Movie movieObj = movieRepo.save(movie);
	            return new ResponseEntity<>(movieObj, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }


	 @PostMapping("/updateMovie/{id}")
	    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
	        try {
	            Optional<Movie> movieData = movieRepo.findById(id);
	            if (movieData.isPresent()) {
	            	Movie updatedMovieData = movieData.get();
	                updatedMovieData.setTitle(movie.getTitle());
	                updatedMovieData.setDirector(movie.getDirector());

	                Movie movieObj = movieRepo.save(updatedMovieData);
	                return new ResponseEntity<>(movieObj, HttpStatus.CREATED);
	            }

	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	 @DeleteMapping("/deleteMovieById/{id}")
	    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable Long id) {
	        try {
	        	movieRepo.deleteById(id);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }}