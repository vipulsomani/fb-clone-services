package com.example.demo.model;

public class Feed {
private String message;
private String image;
private String name;
private String profilePic;
private int likeCount;
private int postId;


public Feed(String message, String image, String name, String profilePic, int likeCount, int postId) {
	super();
	this.message = message;
	this.image = image;
	this.name = name;
	this.profilePic = profilePic;
	this.likeCount = likeCount;
	this.postId =postId;
	
}
public void setMessage(String message) {
	this.message = message;
}
public void setImage(String image) {
	this.image = image;
}
public void setName(String name) {
	this.name = name;
}
public void setProfilePic(String profilePic) {
	this.profilePic = profilePic;
}
public String getMessage() {
	return message;
}
public String getImage() {
	return image;
}
public String getName() {
	return name;
}
public String getProfilePic() {
	return profilePic;
}
public int getLikeCount() {
	return likeCount;
}
public void setLikeCount(int likeCount) {
	this.likeCount = likeCount;
}
public int getPostId() {
	return postId;
}
public void setPostId(int postId) {
	this.postId = postId;
}

}
