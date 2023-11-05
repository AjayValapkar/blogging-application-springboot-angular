package com.linkmingle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.linkmingle.dto.BlogDto;
import com.linkmingle.dto.PostDto;

@Service
public interface BlogPostService {

	void createPost(BlogDto blogDto, Integer userId, Integer categoryId);

	List<BlogDto> getUsersBlogs(Integer userId);

	void updatePost(BlogDto blogDto, Integer userId,Integer categoryId,  Long blogId);

	BlogDto getUserBlogById(Long blogId, Integer categoryid);

	void deleteBlogById(Long blogId);

	List<BlogDto> getAllBloPost();

	List<BlogDto> getBlogByCate(Integer categoryid);

	
	
	
}