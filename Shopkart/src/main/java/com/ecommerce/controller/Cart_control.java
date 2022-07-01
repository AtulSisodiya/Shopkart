package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Cart;
import com.ecommerce.repo.CartRepo;

@RestController
@RequestMapping("/cart")
public class Cart_control {
	@Autowired
	CartRepo cartrepo;
	@PostMapping("/add")
	public List<Cart> adddata(@RequestBody Cart ab){
		cartrepo.save(ab);
		return cartrepo.findAll();
		}

	@GetMapping("/")
	public List<Cart> showdata(){
		return cartrepo.findAll();
		
	}
	
	@PutMapping("/update")
	public List<Cart> updatedata(@RequestBody Cart ab){
		cartrepo.save(ab);
		return cartrepo.findAll();
		}
}
