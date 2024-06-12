package com.example.demo.comment;

import java.time.LocalDateTime;

import com.example.demo.blog.Blog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment implements CommentDataInterface {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "blog_id", referencedColumnName = "blog_id")
	private Blog blog;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "article", nullable = false)
	private String article;

	@Column(name = "posttime", nullable = true)
	private LocalDateTime postTime = LocalDateTime.now();

	@Column(name = "updatetime", nullable = true)
	private LocalDateTime updateTime = LocalDateTime.now();

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Blog getBlog() {
		return blog;
	}

	@Override
	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getArticle() {
		return article;
	}

	@Override
	public void setArticle(String article) {
		this.article = article;
	}

	@Override
	public LocalDateTime getPostTime() {
		return postTime;
	}

	@Override
	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}

	@Override
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	@Override
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
}
