package com.movies.movieProject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.movieProject.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUserName(String userName);
     
	Page<User> findAll(Pageable pageable);
}
