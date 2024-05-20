package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

	@Autowired
	DataService service;
	
	@GetMapping("/")
	@CrossOrigin
	public List<? extends DataInterface> index() {
		System.out.println("Controller:index");
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	@CrossOrigin
	public DataInterface index(@PathVariable int id) {
		System.out.println("Controller:index id["+id+"]");
		return service.getById(id);
	}
	
	@PostMapping("/")
	@CrossOrigin
	public long post(@RequestBody DummyData data) {
		System.out.println("Controller:index(post)");
		service.add(data);
		return data.getId();
	}
}
