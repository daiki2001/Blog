package com.example.demo.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
	@Autowired
	private BlogRepository repository;

	public List<? extends BlogDataInterface> getAll() {
		System.out.println("Service:getAll");
		return repository.findAll();
	}
}
