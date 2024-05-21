package com.example.demo.blog;

import java.time.LocalDateTime;

public interface BlogDataInterface {
	public int getId();
	public String getTitle();
	public String getArticle();
	public LocalDateTime getPostTime();
	public LocalDateTime getUpdateTime();
	
	public void setId(int id);
	public void setTitle(String title);
	public void setArticle(String article);
	public void setPostTime(LocalDateTime posttime);
	public void setUpdateTime(LocalDateTime updatetime);
}
