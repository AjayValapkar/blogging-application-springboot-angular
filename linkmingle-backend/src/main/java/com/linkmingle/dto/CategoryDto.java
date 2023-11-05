package com.linkmingle.dto;

public class CategoryDto {
	private Integer categoryid;

	private String categoryname;

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(Integer categoryid, String categoryname) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "CategoryDto [categoryid=" + categoryid + ", categoryname=" + categoryname + "]";
	}

}
