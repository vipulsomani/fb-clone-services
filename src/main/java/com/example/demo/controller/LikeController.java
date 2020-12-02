package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Feed;
import com.example.demo.model.Like;
import com.example.demo.model.Post;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class LikeController {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private LikeRepository likeRepository;
	

	@PostMapping("/like/{postId}")
	public String likePost(@PathVariable(value = "postId") int postId, @RequestBody Like like) {
		Like myLike = likeRepository.findByUserIdPostId(like.getUserId(), postId);
		if(myLike != null) {
			likeRepository.delete(myLike);
			return "Disliked";
		}else {
		return postRepository.findById(postId).map(post -> {
			like.setPost(post);
			likeRepository.save(like);
			return "liked";
		}).orElseThrow(()->new RuntimeException());
		}
	}
	
}
