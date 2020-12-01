package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Feed;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
		
	@GetMapping("/fb")
	public List<Feed> getAllPost(){
		List<Feed> myFeed = new ArrayList<Feed>();
		List<Post> myPost = postRepository.findAll();
		for (Post post : myPost) {
			userRepository.findById(post.getUser().getId()).map(user -> 
			 myFeed.add(new Feed(post.getMessage(), post.getImage(), user.getName(), user.getProfilePic())));
		}
		return myFeed;
	}
	
	@PostMapping("/fb/{userId}")
	public Feed addPost(@PathVariable(value = "userId") int userId, @RequestBody Post post) {
		return userRepository.findById(userId).map(user -> {
			post.setUser(user);
			postRepository.save(post);
			return new Feed(post.getMessage(), post.getImage(), user.getName(), user.getProfilePic());
		}).orElseThrow(()->new RuntimeException());		
	}
	
}


