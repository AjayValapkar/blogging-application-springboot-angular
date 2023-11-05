package com.linkmingle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.linkmingle.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
 
}
