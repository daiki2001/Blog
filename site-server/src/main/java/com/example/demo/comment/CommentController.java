package com.example.demo.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
	@Autowired
	CommentService service;
	
	@GetMapping("blog/comment")
	@CrossOrigin
	public List<? extends CommentDataInterface> allComment() {
		System.out.println("blog/allComment");
		return service.getAll();
	}
	
	@GetMapping("blog/comment/{blog}")
	@CrossOrigin
	public List<? extends CommentDataInterface> comment(@PathVariable int blog) {
		System.out.println("blog/comment");
		return service.getBlogComment(blog);
	}
}
