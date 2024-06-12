package com.example.demo.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BlogService;

@RestController
public class BlogController {
	@Autowired
	BlogService service;

	// 一覧取得
	@GetMapping("/")
	@CrossOrigin
	public List<? extends BlogDataInterface> index() {
		System.out.println("index");
		return service.getAll();
	}

	// 個別取得
	@GetMapping("/blog/{id}")
	@CrossOrigin
	public BlogDataInterface blog(@PathVariable("id") int id) {
		System.out.println("index/blog/" + id);
		return service.getById(id);
	}

	// 記事の追加
	@PostMapping("/blog/add")
	@CrossOrigin
	public int add(@RequestBody Blog blog) {
		System.out.println("index/blog/add(post)");
		return service.add(blog);
	}

	// 記事の編集
	@PostMapping("/blog/update")
	@CrossOrigin
	public int update(@RequestBody Blog blog) {
		System.out.println("index/blog/update(post)");
		return service.add(blog);
	}

	// 記事の削除
	@DeleteMapping("/blog/delete")
	@CrossOrigin
	public void delete(@RequestBody Blog blog) {
		System.out.println("index/blog/delete(delete)");
		service.delete(blog);
	}
}
