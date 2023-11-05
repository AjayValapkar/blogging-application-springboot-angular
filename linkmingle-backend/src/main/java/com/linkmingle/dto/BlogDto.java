package com.linkmingle.dto;

import com.linkmingle.models.Category;
import com.linkmingle.models.User;

public class BlogDto {

	private Long blogId;
	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}
    private Integer categoryId;
	public Integer getCategoryid() {
		return categoryId;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryId = categoryid;
	}
	private String title;
	private String content;
	private Category category;
	private User user;

	public BlogDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogDto(String title, String content, Category category, User user) {
		super();
		this.title = title;
		this.content = content;
		this.category = category;
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BlogDto [title=" + title + ", content=" + content + ", category=" + category + ", user=" + user + "]";
	}

}
