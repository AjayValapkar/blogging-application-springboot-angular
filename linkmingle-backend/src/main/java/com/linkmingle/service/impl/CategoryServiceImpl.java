package com.linkmingle.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linkmingle.dto.BlogDto;
import com.linkmingle.dto.CategoryDto;
import com.linkmingle.models.Blog;
import com.linkmingle.models.Category;
import com.linkmingle.models.User;
import com.linkmingle.repository.BlogPostRepository;
import com.linkmingle.repository.CategoryRepository;
import com.linkmingle.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	BlogPostRepository blogRepository;

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> categoryDTOs = new ArrayList<>();

		for (Category category : categories) {
			CategoryDto categoryDTO = new CategoryDto();
			categoryDTO.setCategoryid(category.getCategoryid());
			categoryDTO.setCategoryname(category.getCategoryname());

			categoryDTOs.add(categoryDTO);
		}

		return categoryDTOs;
	}

	@Override
	public List<BlogDto> getCateById(Integer categoryId, User userId) {
//		List<Blog> blogs= categoryRepo.findAllCategoryId(categoryId,userId);
//		List<BlogDto> blogDto=new ArrayList<>();
//		
//
//		for (Blog blog : blogs) {
//			BlogDto blogdto= new BlogDto();
//			Category category= categoryRepo.findById(categoryId).orElse(null);
//			
		
//			
//			
//		}
//
		return null;
	}

	@Override
	public List<BlogDto> getPostByCategory(Integer categoryId) {
		List<Blog> blogsbycategory= blogRepository.findAllByCategory_CategoryId(categoryId);
		
		return null;
	}

}
