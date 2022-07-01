package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ecommerce.entity.Product;
import com.ecommerce.repo.ProductRepo;

@RestController
@RequestMapping("/product")
public class Product_control {
	@Autowired
	ProductRepo prorepo;

	@PostMapping("/add")
	public List<Product> adddata(@RequestBody Product ab){
		prorepo.save(ab);
		return prorepo.findAll();
		}
	
	@PutMapping("/update")
	public List<Product> updatedata(@RequestBody Product ab){
		prorepo.save(ab);
		return prorepo.findAll();
		}
	@GetMapping("/")
	public List<Product> showdata(){
		return prorepo.findAll();
		
	}

}
