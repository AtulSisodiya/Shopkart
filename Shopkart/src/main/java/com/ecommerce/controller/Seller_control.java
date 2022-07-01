package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Seller;
import com.ecommerce.repo.SellerRepo;

@RestController
@RequestMapping("/seller")
public class Seller_control {
@Autowired
SellerRepo sellrepo;

@PostMapping("/add")
public List<Seller> adddata(@RequestBody Seller ab){
	sellrepo.save(ab);
	return sellrepo.findAll();
	}

@GetMapping("/")
public List<Seller> showdata(){
	return sellrepo.findAll();
	
}



}
