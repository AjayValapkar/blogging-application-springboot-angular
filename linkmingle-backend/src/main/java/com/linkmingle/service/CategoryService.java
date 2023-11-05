package com.linkmingle.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.linkmingle.dto.BlogDto;
import com.linkmingle.dto.CategoryDto;
import com.linkmingle.models.Category;
import com.linkmingle.models.User;

@Service
public interface CategoryService {

	List<CategoryDto> getAllCategory();

	List<BlogDto> getCateById(Integer categoryId, User userId);

	List<BlogDto> getPostByCategory(Integer categoryId);

}
