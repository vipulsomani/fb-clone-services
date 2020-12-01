package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="fb_post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int post_id;
	
	@Column(name ="message")
	private String message;
	

	@Column(name ="image")
	private String image;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
	
	
	
	public Post() {
		
	}
	

	

	public Post( String message, String image) {
		super();
		this.message = message;
		this.image = image;
	}




	public Post(int post_id, String message, String image, User user) {
		super();
		this.post_id = post_id;
		this.message = message;
		this.image = image;
		this.user = user;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}





	public int getId() {
		return post_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}




	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", message=" + message + ", image=" + image + ", user=" + user + "]";
	}
	


	
	
}

