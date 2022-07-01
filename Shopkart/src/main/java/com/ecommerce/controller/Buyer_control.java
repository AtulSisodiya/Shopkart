package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Buyer;
import com.ecommerce.repo.BuyerRepo;

@RestController
@RequestMapping("/buyer")
public class Buyer_control {
	@Autowired
	BuyerRepo buyrepo;

	@PostMapping("/add")
	public List<Buyer> adddata(@RequestBody Buyer ab){
		buyrepo.save(ab);
		return buyrepo.findAll();
		}
	@GetMapping("/")
	public List<Buyer> showdata(){
		return buyrepo.findAll();
		
	}
}
