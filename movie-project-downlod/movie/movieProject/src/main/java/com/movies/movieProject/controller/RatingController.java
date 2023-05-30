package com.movies.movieProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.movieProject.entities.Rating;
import com.movies.movieProject.service.RatingService;

@RestController
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
    
	@PostMapping("/rating")
	public Rating addRating(@RequestBody Rating rating) {
		ratingService.addRating(rating);
		return rating;
	}
	
	@GetMapping("/ratings")
	public List<Rating> getRatings() {
		return ratingService.getAllRatings();
	}
	
//	@PostMapping("/ratings")
//	public 
}
