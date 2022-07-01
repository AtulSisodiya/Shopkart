package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Category;
import com.ecommerce.repo.CategoryRepo;

@RestController
@RequestMapping("/category")
public class Category_control {

	@Autowired
	CategoryRepo cr;
	
	@GetMapping("/")
	public List<Category> showdata(){
		return cr.findAll();
	}
	
	@PostMapping("/add")
	public List<Category> adddata(@RequestBody Category ab){
		cr.save(ab);
		return cr.findAll();
		}
	
	@PutMapping("/update")
	public List<Category> updatedata(@RequestBody Category ab){
		cr.save(ab);
		return cr.findAll();
		}

	@DeleteMapping("/{id}")
	public List<Category> deldata(@PathVariable Long id){
		cr.deleteById(id);
		return cr.findAll();
	}
}
