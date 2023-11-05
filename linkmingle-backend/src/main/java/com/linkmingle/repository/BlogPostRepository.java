package com.linkmingle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linkmingle.models.Blog;
import com.linkmingle.models.User;

@Repository
public interface BlogPostRepository extends JpaRepository<Blog, Long> {

	List<Blog> findByAuthorUserId(Integer userid);

	List<Blog> findByCategory_CategoryId(Integer categoryId);

	List<Blog> findAllByCategory_CategoryId(Integer categoryId);
}
