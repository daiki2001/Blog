package com.example.demo.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
	@Autowired
	CommentService service;

	// 一覧取得
	@GetMapping("blog/comment")
	@CrossOrigin
	public List<? extends CommentDataInterface> allComment() {
		System.out.println("blog/allComment");
		return service.getAll();
	}

	// 個別取得
	@GetMapping("blog/comment/{blog_id}")
	@CrossOrigin
	public List<? extends CommentDataInterface> comment(@PathVariable int blog_id) {
		System.out.println("blog/comment/"+blog_id);
		return service.getBlogComment(blog_id);
	}
	
//	コメントの追加
	@PostMapping("/blog/comment/add")
	@CrossOrigin
	public int add(@RequestBody Comment comment) {
		System.out.println("index/blog/comment/add(post)");
		return service.add(comment);
	}
	
//	コメントの編集
	@PostMapping("/blog/comment/update")
	@CrossOrigin
	public int update(@RequestBody Comment comment) {
		System.out.println("index/blog/comment/update(post)");
		return service.add(comment);
	}
	
//	コメントの削除
	@DeleteMapping("/blog/comment/delete")
	@CrossOrigin
	public void delete(@RequestBody Comment comment) {
		System.out.println("index/blog/comment/delete(delete)");
		service.delete(comment);
	}
}
