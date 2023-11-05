package com.linkmingle.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String firstname;
	private String lastname;
	private String email;
	private String password;

	@OneToMany(mappedBy = "author")
	private List<Blog> blog;

	@OneToMany(mappedBy = "author")
	private List<Comment> comments;

	public User() {
	}

	public User(Integer userid, String firstname, String lastname, String email, String password) {
		super();
		this.userId = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public Integer getUserid() {
		return userId;
	}

	public void setUserid(Integer userid) {
		this.userId = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Blog> getBlogs() {
		return blog;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blog = blogs;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User(Integer userid, String firstname, String lastname, String email, String password, List<Blog> blogs,
			List<Comment> comments) {
		super();
		this.userId = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.blog = blogs;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "User [userid=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", blogs=" + blog + ", comments=" + comments + "]";
	}

}
