package com.movies.movieProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movies.movieProject.entities.Director;
import com.movies.movieProject.service.DirectorService;

@RestController
public class DirectorController {

	@Autowired
	private DirectorService directorService;

	@PostMapping("/director")
	public Director addDirector(@RequestBody Director director) {
		directorService.addDirector(director);
		return director;
	}
	
	@GetMapping("/directors")
	public List<Director> getDirectors(){
		return directorService.getAllDirectors();
	}
	
	@GetMapping("/director/{first_name}")
	public List<Director> getDirectorByName(@PathVariable("first_name") String firstName){
		return directorService.getDirectorsByName(firstName);
		
	}
}
