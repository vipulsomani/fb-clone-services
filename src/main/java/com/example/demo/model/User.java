package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int userId;
	
	@Column(name= "name")
	private String name;
	 
	@Column(unique=true)
	private String email;
	
	@Column(name ="profile_pic")
	private String profilePic;
	
	
	 public User() {
		 
	 }
	 	public User(String name, String email, String profilePic) {
		super();
		this.name = name;
		this.email = email;
		this.profilePic = profilePic;
	}




	public int getId() {
		return userId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}


	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + name + ", email=" + email + ", profilePic=" + profilePic + "]";
	}
	 
	
}
