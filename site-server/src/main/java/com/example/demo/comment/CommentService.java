package com.example.demo.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	@Autowired
	private CommentRepository repository;

	public List<? extends CommentDataInterface> getAll() {
		System.out.println("Service:getAll");
		return repository.findAll();
	}
}
