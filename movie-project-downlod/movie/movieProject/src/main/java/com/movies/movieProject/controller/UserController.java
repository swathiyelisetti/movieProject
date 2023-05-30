package com.movies.movieProject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movies.movieProject.dto.UserDto;
import com.movies.movieProject.entities.User;
import com.movies.movieProject.repository.UserRepo;
import com.movies.movieProject.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepo userRepo;

	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/user/{user_id}")
	public Optional<User> getUser(@PathVariable("user_id") int userid) {
		return userRepo.findById(userid);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@DeleteMapping("/user/{user_id}")
	public String deleteUserById(@PathVariable("user_id") int userId) {

		User user = userRepo.findById(userId).get();
		if (user == null) {
			return "user not found";
		} else {
			userRepo.deleteById(userId);
			return "user deleted";
		}

	}
	
	@PostMapping("/adduser")
	public UserDto createNewUser(@RequestBody UserDto userDto) {
		return userService.addNewUserByDto(userDto);
		
	}
	
	@GetMapping("/usersByPagenation")
	public ResponseEntity<List<User>> getUsers(@RequestParam(defaultValue="0") int pageNo,
			@RequestParam(defaultValue="5") int pageSize,@RequestParam(defaultValue="userId") String sortBy){
		List<User> list=userService.getAllUsers(pageNo, pageSize,sortBy );
		return new ResponseEntity<List<User>> (list,HttpStatus.OK);
	}
	
	
	
}
