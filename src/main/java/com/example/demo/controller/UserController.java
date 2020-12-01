package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Feed;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		User myUser =  userRepository.findByEmail(user.getEmail());
		if (myUser != null) {
			return myUser;
		} else {
			return userRepository.save(user);
		}
	}
	
	@GetMapping("/user")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
}
