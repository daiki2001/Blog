package com.example.demo.blog;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
	public Optional<Blog> findById(int id);
	
	@Query(value = "SELECT * FROM blog WHERE title LIKE '%:key%' OR article LIKE '%:key%'", nativeQuery = true)
	public List<Blog> fuzzySearch(@Param("key") String key);
}
