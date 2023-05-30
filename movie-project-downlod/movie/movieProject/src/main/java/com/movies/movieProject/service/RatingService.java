package com.movies.movieProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.movies.movieProject.dto.RatingDto;
import com.movies.movieProject.entities.Movie;
import com.movies.movieProject.entities.Rating;
import com.movies.movieProject.entities.User;
import com.movies.movieProject.repository.RatingRepo;
import com.movies.movieProject.repository.UserRepo;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepo ratingRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public Rating addRating(Rating rating) {
		ratingRepo.save(rating);
		return rating;
	}
	
	public RatingDto convertToDto(Rating rating) {
		RatingDto ratingDto=new RatingDto();
		ratingDto.setMovieId(rating.getMovie().getMovieId());
		ratingDto.setRatingId(rating.getRatingId());
		ratingDto.setComment(rating.getComment());
		ratingDto.setUserId(rating.getUser().getUserId());
		return ratingDto;
		
		
	}
	
//	 public Rating convertToMovieRatingEntity(RatingDto ratingDto) {
//	        Rating rating = new Rating();
//	        rating.setRatingId(ratingDto.getRatingId());
//	        rating.setComment(ratingDto.getComment());
//	        rating.setRatingId(ratingDto.getRatingId());
//	        rating.setMovie(convertToMovieEntity(ratingDto.getMovieId()));
//	        rating.setUser(ratingDto.getUserId());
//	        return rating;
//	    }
//	}
	
	public List<Rating> getAllRatings() {
		return ratingRepo.findAll();
	}
	
//	public String updateComment(User user,Movie movie) {
//		int uid= user.getUserId();
//		 int mid=movie.getMovieId();
//		 
//		 if(uid==)
//	}
//	
	

}

