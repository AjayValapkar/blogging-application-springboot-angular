package com.linkmingle.dto;

import com.linkmingle.models.Category;
import com.linkmingle.models.User;

public class PostDto {
	private int Postid;
	private String title;
	private String content;
	private User user;

	public int getPostid() {
		return Postid;
	}

	public void setPostid(int postid) {
		Postid = postid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return content;
	}

	public void setDescription(String description) {
		this.content = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	private Category category;
}