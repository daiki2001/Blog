package com.example.demo.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	@Query(value = "SELECT * FROM comment WHERE comment.blog_id = :key", nativeQuery = true)
	public List<Comment> findByBlog(@Param("key") int key);
}
