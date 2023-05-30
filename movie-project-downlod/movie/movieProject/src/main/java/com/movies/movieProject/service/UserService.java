package com.movies.movieProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.movies.movieProject.dto.UserDto;
import com.movies.movieProject.entities.User;
import com.movies.movieProject.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public User addUser(@RequestBody User user) {
		userRepo.save(user);
		return user;
	}

//   public List<UserDto> getAllUsers(){
//	   return null;
//   }

	private UserDto convertToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setUserId(user.getUserId());
		userDto.setUserName(user.getUserName());
		userDto.setPassword(user.getPassword());
		return userDto;

	}

	private User convertToEntity(UserDto userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setPassword(userDto.getPassword());
		user.setUserName(userDto.getUserName());
		return user;

	}

	public UserDto addNewUserByDto(UserDto userDto) {
		User user = convertToEntity(userDto);
		User savedUser = userRepo.save(user);
		return convertToDto(savedUser);
	}

	public List<User> getAllUsers(int PageNo,int PageSize,String sortBy){
		Pageable paging=PageRequest.of(PageNo, PageSize, Sort.by(sortBy));
		Page<User> pagedResult=userRepo.findAll(paging);
		if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		}else {
			return new ArrayList<User>();
		}
	}

}
