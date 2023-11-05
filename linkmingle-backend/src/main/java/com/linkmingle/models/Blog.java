package com.linkmingle.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "blogid")
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long blogId;
	private String title;
	private String content;

	private int likes;
	private int dislikes;

	@ManyToOne
	private User author;

	@OneToMany(mappedBy = "blog")
	private List<Comment> comments;

	@JsonIgnore
	@ManyToOne
	private Category category;

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blog(Long blogid, String title, String content, int like, int dislike, User author,
			List<Comment> comments, Category category) {
		super();
		this.blogId = blogid;
		this.title = title;
		this.content = content;
		this.likes = like;
		this.dislikes = dislike;
		this.author = author;
		this.comments = comments;
		this.category = category;
	}
	

	public Long getBlogid() {
		return blogId;
	}

	public void setBlogid(Long blogid) {
		this.blogId = blogid;
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

	public int getLike() {
		return likes;
	}

	public void setLike(int like) {
		this.likes = like;
	}

	public int getDislike() {
		return dislikes;
	}

	public void setDislike(int dislike) {
		this.dislikes = dislike;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Blog [blogid=" + blogId + ", title=" + title + ", content=" + content + ", like=" + likes + ", dislike="
				+ dislikes + ", author=" + author + ", comments=" + comments + ", category=" + category + "]";
	}

}
