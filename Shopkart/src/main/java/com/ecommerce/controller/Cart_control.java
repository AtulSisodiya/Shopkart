package com.ecommerce.controller;

import java.util.Iterator;
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

import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Product;
import com.ecommerce.repo.CartRepo;
import com.ecommerce.service.AdminService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/cart")
public class Cart_control {
	@Autowired
	CartRepo cartrepo;
	
	@Autowired
	AdminService as;
	
	
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
	
	@DeleteMapping("/delete/")
	public List<Cart> deletepid(@RequestBody JsonNode rb){
		return as.deldata( rb.get("cartId").asLong(), rb.get("productId").asLong());
	}
		
		
	}

