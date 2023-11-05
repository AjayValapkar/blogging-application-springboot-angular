package com.linkmingle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linkmingle.dto.BlogDto;
import com.linkmingle.service.BlogPostService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/blogs")
public class BlogPostController {

//localhost:8080/blogs/user/{userId}/category/{categoryId}/posts
	@Autowired
	BlogPostService blogpostService;
	
	@GetMapping("/")
	public List<BlogDto> getAllBlogs(){
		return blogpostService.getAllBloPost();
	}
	
	@GetMapping("/{categoryId}")
	public List<BlogDto> getBlogByCateGory(@PathVariable Integer categoryId){
		return blogpostService.getBlogByCate(categoryId);
	}

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<String> createBlogPost(@RequestBody BlogDto blogDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId) {

		try {
			blogpostService.createPost(blogDto, userId, categoryId);
			return ResponseEntity.ok("User successfully registered with ID: " + userId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Registration failed: " + e.getMessage());
		}
	}

	@GetMapping("/user/{userId}")
	public List<BlogDto> getUserBlogs(@PathVariable Integer userId) {
		return blogpostService.getUsersBlogs(userId);
	}

	@PutMapping("/user/{userId}/category/{categoryId}/update/{blogId}")
	public ResponseEntity<String> updateBlog(@RequestBody BlogDto blogDto, @PathVariable Integer userId,
			@PathVariable Integer categoryId, @PathVariable Long blogId) {
		try {
			blogpostService.updatePost(blogDto, userId, categoryId, blogId);
			return ResponseEntity.ok("Post Updated Suceesssfully " + userId);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Registration failed: " + e.getMessage());
		}
	}

	@GetMapping("/{blogId}/category/{categoryid}")
	public BlogDto getUserPost(@PathVariable Long blogId, @PathVariable Integer categoryid) {
		return blogpostService.getUserBlogById(blogId, categoryid);
	}

	@DeleteMapping("/{blogId}")
	public void deletePost(@PathVariable Long blogId) {
		blogpostService.deleteBlogById(blogId);

	}

}
