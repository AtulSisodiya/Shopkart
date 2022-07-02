package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Wallet;
import com.ecommerce.repo.WalletRepo;

@RestController
@RequestMapping("/wallet")
public class Wallet_control {

	@Autowired
	WalletRepo wr;
	
	@GetMapping("/")
	public List<Wallet> show(){
		return wr.findAll();
	}
	
	@PostMapping("/add")
	public List<Wallet> add(@RequestBody Wallet ab){
		wr.save(ab);
		return wr.findAll();
	}
	
	@PutMapping("/update")
	public List<Wallet> update(@RequestBody Wallet ab){
		wr.save(ab);
		return wr.findAll();
	}
}
