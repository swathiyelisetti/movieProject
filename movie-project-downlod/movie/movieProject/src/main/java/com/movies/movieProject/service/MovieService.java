package com.movies.movieProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.movies.movieProject.dto.MovieDto;
import com.movies.movieProject.entities.Movie;
import com.movies.movieProject.repository.MovieRepo;

@Service
public class MovieService {

	@Autowired
	private MovieRepo movieRepo;

	public Movie addMovie(@RequestBody Movie movie) {
		movieRepo.save(movie);
		return movie;

	}

	public MovieDto convertToDto(Movie movie) {
		MovieDto movieDto = new MovieDto();
		movieDto.setDirectorId(movie.getDirector().getDirectorId());
		movieDto.setMovieId(movie.getMovieId());
		movieDto.setMovieName(movie.getMovieName());
		movieDto.setYear(movie.getYear());
		return movieDto;

	}

//	  public static Movie convertToEntity(MovieDto movieDTO) {
//	        Movie movie = new Movie();
//	        movie.setMovieId(movieDTO.getMovieId());
//	        movie.setMovieName(movieDTO.getMovieName());
//	        movie.setYear(movieDTO.getYear());
//	        movie.setDirector(convertToEntity(movieDTO.getDirectorId()));
//	        return movie;
//	    }

//	public List<Movie> getAllMovies(){
//		movieRepo.getClass()
//	}
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}

}
