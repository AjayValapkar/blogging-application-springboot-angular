package com.linkmingle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkmingle.dto.BlogDto;
import com.linkmingle.models.Blog;
import com.linkmingle.models.Category;
import com.linkmingle.models.User;
import com.linkmingle.repository.BlogPostRepository;
import com.linkmingle.repository.CategoryRepository;
import com.linkmingle.repository.UserRepository;
import com.linkmingle.service.BlogPostService;

@Service
public class BlogPostServiceImpl implements BlogPostService {

	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	BlogPostRepository blogrepository;

	@Override
	public void createPost(BlogDto blogDto, Integer userId, Integer categoryId) {
		User user = userRepo.findById(userId).orElse(null);
		Category category = categoryRepo.findById(categoryId).orElse(null);

		Blog post = new Blog();
		post.setTitle(blogDto.getTitle());
		post.setContent(blogDto.getContent());
		post.setAuthor(user);
		post.setCategory(category);
		blogrepository.save(post);

	}

	@Override
	public List<BlogDto> getUsersBlogs(Integer userid) {
		List<Blog> blogs = blogrepository.findByAuthorUserId(userid);
		List<BlogDto> blogdto = new ArrayList<>();

		for (Blog blogpost : blogs) {
			BlogDto blogdtos = new BlogDto();
			blogdtos.setBlogId(blogpost.getBlogid());
			blogdtos.setTitle(blogpost.getTitle());
			blogdtos.setContent(blogpost.getContent());
			Category category = blogpost.getCategory();
			blogdtos.setCategoryid(category.getCategoryid());
			blogdto.add(blogdtos);

		}
		return blogdto;
	}

	@Override
	public void updatePost(BlogDto blogDto, Integer userId, Integer categoryId, Long blogId) {
		User user = userRepo.findById(userId).orElse(null);
		Category category = categoryRepo.findById(categoryId).orElse(null);
		Blog post = new Blog();
		post = blogrepository.findById(blogId).orElse(null);
		post.setTitle(blogDto.getTitle());
		post.setContent(blogDto.getContent());
		post.setAuthor(user);
		post.setCategory(category);
		blogrepository.save(post);

	}

	@Override
	public BlogDto getUserBlogById(Long blogId, Integer categoryid) {
		Blog blog = blogrepository.findById(blogId).orElse(null);
		Category category = categoryRepo.findById(categoryid).orElse(null);
		BlogDto post = new BlogDto();
		post.setBlogId(blog.getBlogid());
		post.setTitle(blog.getTitle());
		post.setContent(blog.getContent());
		post.setCategory(category);
		return post;
	}

	@Override
	public void deleteBlogById(Long blogId) {
		Blog blog = blogrepository.findById(blogId).orElse(null);
		blogrepository.delete(blog);

	}

	@Override
	public List<BlogDto> getAllBloPost() {
		List<Blog> blogs = blogrepository.findAll();
		List<BlogDto> blogdto = new ArrayList<>();

		for (Blog blogpost : blogs) {
			BlogDto blogdtos = new BlogDto();
			blogdtos.setBlogId(blogpost.getBlogid());
			blogdtos.setTitle(blogpost.getTitle());
			blogdtos.setContent(blogpost.getContent());
			Category category = blogpost.getCategory();
			blogdtos.setCategoryid(category.getCategoryid());
			blogdto.add(blogdtos);
		}
		return blogdto;
	}

	@Override
	public List<BlogDto> getBlogByCate(Integer categoryid) {
		List<Blog> blogs = blogrepository.findByCategory_CategoryId(categoryid);
		List<BlogDto> blogdto = new ArrayList<>();

		for (Blog blogpost : blogs) {
			BlogDto blogdtos = new BlogDto();
			blogdtos.setBlogId(blogpost.getBlogid());
			blogdtos.setTitle(blogpost.getTitle());
			blogdtos.setContent(blogpost.getContent());
			Category category = blogpost.getCategory();
			blogdtos.setCategoryid(category.getCategoryid());
			blogdto.add(blogdtos);

		}
		return blogdto;
	}

}
