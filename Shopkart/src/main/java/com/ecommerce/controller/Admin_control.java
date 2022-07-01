package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.service.AdminService;

@RestController
@RequestMapping("/admin")
public class Admin_control {
@Autowired
AdminService adservice;
	//Admin Login
	@GetMapping("/login")
	public ResponseEntity<String> loginAdmin(@RequestParam String username ,@RequestParam String password ) {
		return adservice.loginAdmin(username,password);
	}
	
	//Validate Seller
	@PutMapping("/approve/seller")
	public ResponseEntity<String> sellerApproval(@RequestParam Long sellerId) {
		return adservice.sellerApproval(sellerId);
	}
	
	//approve place order
	@PutMapping("/approve/order")
	public ResponseEntity<String> orderApproval(@RequestParam Long placeOrderId) {
		return adservice.orderApproval(placeOrderId);
	}
	
	//buyer login
	@GetMapping("/buyer/login")
	public ResponseEntity<String> loginbuyer(@RequestParam String username ,@RequestParam String password ) {
		return adservice.loginbuyer(username,password);
	}
	
	//seller login
	@GetMapping("/seller/login")
	public ResponseEntity<String> loginseller(@RequestParam String username ,@RequestParam String password ) {
		return adservice.loginseller(username,password);
	}
	
	

}
