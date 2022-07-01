package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.PlaceOrder;
import com.ecommerce.repo.PlaceOrderRepo;

@RestController
@RequestMapping("/placeorder")
public class Placeorder_control {

	@Autowired
	PlaceOrderRepo po;
	
	@GetMapping("/")
	public List<PlaceOrder> showdata(){
		return po.findAll();
	}
	
	@PostMapping("/add")
	public List<PlaceOrder> adddata(@RequestBody PlaceOrder ab){
		po.save(ab);
		return po.findAll();
	}
	
	@PutMapping("/update")
	public List<PlaceOrder> updatedata(@RequestBody PlaceOrder ab){
		po.save(ab);
		return po.findAll();
	}
}
