package com.movies.movieProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.movieProject.entities.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {

}
