package com.linkmingle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkmingle.dto.BlogDto;
import com.linkmingle.dto.CategoryDto;
import com.linkmingle.models.User;
import com.linkmingle.service.BlogPostService;
import com.linkmingle.service.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/users/blogs/category")
public class CategoryController {
	
//	http://localhost:8080/users/blogs/category
	
	@Autowired
	CategoryService categoryservice;
	
	@Autowired
	BlogPostService blogpostserive;
	
	@GetMapping
	public List<CategoryDto> getCategory(){
		return categoryservice.getAllCategory();
	}
	
	@GetMapping("/{categoryId}/user/{userId}")
	public List<BlogDto> getCategoryById(@PathVariable Integer categoryId,@PathVariable User userId){
		return categoryservice.getCateById(categoryId,userId);
		
	}
	
	public List<BlogDto> getPostByCategory(@PathVariable Integer categoryId) {
		return categoryservice.getPostByCategory(categoryId);

	}
	
	
	
	

}
