package com.movies.movieProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.movieProject.entities.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating,Integer>{

}
