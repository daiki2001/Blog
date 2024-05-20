package com.example.demo;
 
import java.util.Date;
 
public interface DataInterface {
	public long getId();
	public String getName();
	public String getMessage();
	public Date getPosted();
	public void setId(long id);
	public void setName(String name);
	public void setMessage(String message);
	public void setPosted(Date posted);
}        
