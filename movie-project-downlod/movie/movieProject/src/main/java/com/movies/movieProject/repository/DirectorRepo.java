package com.movies.movieProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.movieProject.entities.Director;

@Repository
public interface DirectorRepo extends JpaRepository<Director,Integer>{

	List<Director> findByFirstName(String firstName);

}
