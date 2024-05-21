package com.example.demo.blog;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "blog")
public class Blog implements BlogDataInterface {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blog_id")
	private int id;

	@Column(name = "title", nullable = false)
	private String title;

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
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
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
