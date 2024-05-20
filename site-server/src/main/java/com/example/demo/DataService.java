package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DataService {
	private ArrayList<DataInterface> data = new ArrayList<DataInterface>();
	
	public DataService() {
		super();
		
		data.add(new DummyData("熊谷", "こんにちは！"));
		data.add(new DummyData("熊谷", "緊張しますけれどよろしくお願いいたします"));
		data.add(new DummyData("古田", "熊谷さん、ようこそ！"));
		data.add(new DummyData("古田", "肩の力を抜いていきましょう！"));
	}
	
	public List<? extends DataInterface> getAll() {
		System.out.println("Service:getAll");
		return data;
	}
	
	public DataInterface getById(int id) {
		System.out.println("Service:getById id[" + id + "]");
		for (DataInterface item : data) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}
	
	public void add(DataInterface item) {
		System.out.println("Service:add [" + item + "]");
		data.add(0, item);
	}
}
