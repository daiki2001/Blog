package com.example.demo.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
	@Autowired
	private BlogRepository repository;

	// 一覧取得
	public List<? extends BlogDataInterface> getAll() {
		System.out.println("Service:getAll");
		return repository.findAll();
	}

	// 個別取得
	public BlogDataInterface getById(int id) {
		System.out.println("Service:getById");
		return repository.findById(id).orElse(null);
	}

	// 追加・更新
	public int add(BlogDataInterface item) {
		System.out.println("Service:add [" + item + "]");
		if (item instanceof Blog) {
			Blog savedItem = repository.saveAndFlush((Blog)item);
			return savedItem.getId();
		}
		return 0;
	}
}
