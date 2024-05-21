package com.example.demo.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
	@Autowired
	CommentService service;
	
	@GetMapping("blog/comment")
	@CrossOrigin
	public List<? extends CommentDataInterface> index() {
		System.out.println("blog/comment");
		return service.getAll();
	}
}
