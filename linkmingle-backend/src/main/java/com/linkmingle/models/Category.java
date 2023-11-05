package com.linkmingle.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "categoryid")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	private String categoryname;
	
    @JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Blog> blog;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Category(Integer categoryid, String categoryname) {
		super();
		this.categoryId = categoryid;
		this.categoryname = categoryname;
	}


	public Category(Integer categoryid, String categoryname, List<Blog> blogs) {
		super();
		this.categoryId = categoryid;
		this.categoryname = categoryname;
		this.blog = blogs;
	}

	public Integer getCategoryid() {
		return categoryId;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryId = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public List<Blog> getBlogs() {
		return blog;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blog = blogs;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryId + ", categoryname=" + categoryname + ", blogs=" + blog + "]";
	}
	

}
