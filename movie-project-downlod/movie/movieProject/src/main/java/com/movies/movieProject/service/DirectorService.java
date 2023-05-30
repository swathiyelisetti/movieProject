package com.movies.movieProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.movies.movieProject.dto.DirectorDto;
import com.movies.movieProject.entities.Director;
import com.movies.movieProject.repository.DirectorRepo;

@Service
public class DirectorService {
	@Autowired
	private DirectorRepo directorRepo;

	public Director addDirector(@RequestBody Director director) {
		directorRepo.save(director);
		return director;
	}

	public DirectorDto convertToEntity(Director director) {
		DirectorDto directorDto = new DirectorDto();
		directorDto.setDirectorId(director.getDirectorId());
		directorDto.setDirectorName(director.getFirstName());
		directorDto.setDirectorName(director.getLastName());
		directorDto.setBio(director.getBio());
		return directorDto;
	}

//	public List<Director> getAllDirectors(){
//		directorRepo.
//	}
//	 public static DirectorDto convertToDirectorDTO(Director director) {
//	        DirectorDto directorDto = new DirectorDto();
//	        directorDto.setDirectorId(director.getDirectorId());
//	        directorDto.setDirectorName(director.getDirectorName());
//	        directorDto.setBio(director.getBio());
//	        return directorDto;
//	    }

	public List<Director> getAllDirectors() {
		return directorRepo.findAll();
	}

	public List<Director> getDirectorsByName(String firstName) {
		return directorRepo.findByFirstName(firstName);
	}

}
