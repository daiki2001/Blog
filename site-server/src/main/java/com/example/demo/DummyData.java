package com.example.demo;
 
import java.util.Calendar;
import java.util.Date;
 
public class DummyData implements DataInterface {
	private static long counter = 1;
	private long id;
	private String name;
	private String message;
	private Date posted;
   
	public DummyData() {
		this("","");
	}

	public DummyData(String name, String message) {
		super();
		this.id = DummyData.counter++;
		this.name = name;
		this.message = message;
		this.posted = Calendar.getInstance().getTime();
	}
   
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
  
	public void setName(String name) {
		this.name = name;
	}
  
	public String getMessage() {
		return message;
	}
  
	public void setMessage(String message) {
		this.message = message;
	}
  
	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}
	
	public String toString() {
		return "id[" + id + "] name["+ name +"] message[" + message + "] posted[" + posted + "]";
	}
}         
