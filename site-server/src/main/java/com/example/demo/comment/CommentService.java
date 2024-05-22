package com.example.demo.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
	@Autowired
	private CommentRepository repository;

	// 一覧取得
	public List<? extends CommentDataInterface> getAll() {
		System.out.println("CommentService:getAll");
		return repository.findAll();
	}

	// 個別取得
	public List<? extends CommentDataInterface> getBlogComment(int key) {
		System.out.println("CommentService:getBlogComment");
		return repository.findByBlog(key);
	}

	// 追加・更新
	public int add(CommentDataInterface item) {
		System.out.println("CommentService:add [" + item + "]");
		if (item instanceof Comment) {
			if (item.getBlog() == null) System.out.println("item.blogはnullです");
			Comment savedItem = repository.saveAndFlush((Comment)item);
			return savedItem.getId();
		}
		return 0;
	}

	// 削除
	public void delete(CommentDataInterface item) {
		System.out.println("CommentService:delete [" + item + "]");
		if (item instanceof Comment) {
			repository.delete((Comment)item);
		}
	}
}
