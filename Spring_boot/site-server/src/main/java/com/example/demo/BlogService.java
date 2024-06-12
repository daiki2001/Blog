package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.blog.Blog;
import com.example.demo.blog.BlogDataInterface;
import com.example.demo.blog.BlogRepository;
import com.example.demo.comment.Comment;
import com.example.demo.comment.CommentDataInterface;
import com.example.demo.comment.CommentRepository;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private CommentRepository commentRepository;

	// 一覧取得
	public List<? extends BlogDataInterface> getAll() {
		System.out.println("BlogService:getAll");
		return blogRepository.findAll();
	}

	// 個別取得
	public BlogDataInterface getById(int id) {
		System.out.println("BlogService:getById");
		return blogRepository.findById(id).orElse(null);
	}

	// 追加・更新
	public int add(BlogDataInterface item) {
		System.out.println("BlogService:add [" + item + "]");
		if (item instanceof Blog) {
			Blog savedItem = blogRepository.saveAndFlush((Blog)item);
			return savedItem.getId();
		}
		return 0;
	}

	// 削除
	public void delete(BlogDataInterface item) {
		System.out.println("BlogService:delete [" + item + "]");
		if (item instanceof Blog) {
			List<? extends CommentDataInterface> comments = getBlogComment(item.getId());
			for (CommentDataInterface comment : comments) {
				delete(comment);
			}
			blogRepository.delete((Blog)item);
		}
	}
	
	// コメント

	// 一覧取得
	public List<? extends CommentDataInterface> getAllComment() {
		System.out.println("CommentService:getAll");
		return commentRepository.findAll();
	}

	// 個別取得
	public List<? extends CommentDataInterface> getBlogComment(int key) {
		System.out.println("CommentService:getBlogComment");
		return commentRepository.findByBlog(key);
	}

	// 追加・更新
	public int add(CommentDataInterface item) {
		System.out.println("CommentService:add [" + item + "]");
		if (item instanceof Comment) {
			if (item.getBlog() == null) System.out.println("item.blogはnullです");
			Comment savedItem = commentRepository.saveAndFlush((Comment)item);
			return savedItem.getId();
		}
		return 0;
	}

	// 削除
	public void delete(CommentDataInterface item) {
		System.out.println("CommentService:delete [" + item + "]");
		if (item instanceof Comment) {
			commentRepository.delete((Comment)item);
		}
	}
}
