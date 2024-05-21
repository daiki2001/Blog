package com.example.demo.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
	@Autowired
	BlogService service;
	
	@GetMapping("/")
	@CrossOrigin
	public List<? extends BlogDataInterface> index() {
		System.out.println("blog/index");
		return service.getAll();
	}
}
