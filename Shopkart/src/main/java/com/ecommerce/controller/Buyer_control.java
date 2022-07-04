package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Buyer;
import com.ecommerce.entity.Product;
import com.ecommerce.repo.BuyerRepo;
import com.ecommerce.repo.ProductRepo;

@RestController
@RequestMapping("/buyer")
public class Buyer_control {
	@Autowired
	BuyerRepo buyrepo;
	
	@Autowired
	ProductRepo pr;

	@PostMapping("/add")
	public List<Buyer> adddata(@RequestBody Buyer ab){
		buyrepo.save(ab);
		return buyrepo.findAll();
		}
	@PutMapping("/update")
	public List<Buyer> updatedata(@RequestBody Buyer ab){
		buyrepo.save(ab);
		return buyrepo.findAll();
		}
	@GetMapping("/")
	public List<Buyer> showdata(){
		return buyrepo.findAll();
		
	}
	
	
	//product search
	@GetMapping("/product/search")
	public List<Product> search(@RequestParam String Keyword){
		
		 List<Product> listsearch=pr.search(Keyword);
		 
		 return listsearch;
	}
	
}
