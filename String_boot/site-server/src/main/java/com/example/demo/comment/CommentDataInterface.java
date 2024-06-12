package com.example.demo.comment;

import java.time.LocalDateTime;

import com.example.demo.blog.Blog;

public interface CommentDataInterface {
	public int getId();
	public Blog getBlog();
	public String getName();
	public String getArticle();
	public LocalDateTime getPostTime();
	public LocalDateTime getUpdateTime();
	
	public void setId(int id);
	public void setBlog(Blog blog);
	public void setName(String name);
	public void setArticle(String article);
	public void setPostTime(LocalDateTime posttime);
	public void setUpdateTime(LocalDateTime updatetime);
}
