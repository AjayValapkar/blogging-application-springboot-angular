package com.linkmingle.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	private String content;

	@ManyToOne
	private User author;

	@ManyToOne
	private Blog blog;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(Long id, String content, User author, Blog blog) {
		super();
		this.commentId = id;
		this.content = content;
		this.author = author;
		this.blog = blog;
	}

	public Long getId() {
		return commentId;
	}

	public void setId(Long id) {
		this.commentId = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		return "Comment [id=" + commentId + ", content=" + content + ", author=" + author + ", blog=" + blog + "]";
	}

}
