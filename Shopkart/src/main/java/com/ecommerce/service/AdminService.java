package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Admin;
import com.ecommerce.entity.Buyer;
import com.ecommerce.entity.PlaceOrder;
import com.ecommerce.entity.Seller;
import com.ecommerce.repo.AdminRepo;
import com.ecommerce.repo.BuyerRepo;
import com.ecommerce.repo.PlaceOrderRepo;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.SellerRepo;
@Service
public class AdminService {
	@Autowired
	AdminRepo adminRepo;

	@Autowired
	SellerRepo sellerrepo;

	@Autowired
	BuyerRepo buyerrepo;

	@Autowired
	ProductRepo productrepo;
	
	@Autowired
	PlaceOrderRepo placeorderrepo;

	public ResponseEntity<String> loginAdmin(String username, String password) {
		if (username.equals(null) || username.equals("")) {
			return new ResponseEntity<String>("Enter Username.... ",HttpStatus.BAD_REQUEST);
		}
		if (password.equals(null) || password.equals("")) {
			return new ResponseEntity<String>("Enter Password.... ",HttpStatus.BAD_REQUEST);
			}
		Admin seller = adminRepo.validate(username, password);
		if (seller != null) {
			return new ResponseEntity<String>("Successfully Login!!",HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Login Failed..Retry Again with Valid Credentials",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public ResponseEntity<String> loginbuyer(String username, String password) {
		if (username.equals(null) || username.equals("")) {
			return new ResponseEntity<String>("Enter Username.... ",HttpStatus.BAD_REQUEST);
		}
		if (password.equals(null) || password.equals("")) {
			return new ResponseEntity<String>("Enter Password.... ",HttpStatus.BAD_REQUEST);
			}
		Buyer buyer = buyerrepo.validate(username, password);
		if (buyer != null) {
			return new ResponseEntity<String>("Successfully Login!!",HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Login Failed..Retry Again with Valid Credentials",HttpStatus.BAD_REQUEST);
		}
	}
	
	
	public ResponseEntity<String> loginseller(String username, String password) {
		if (username.equals(null) || username.equals("")) {
			return new ResponseEntity<String>("Enter Username.... ",HttpStatus.BAD_REQUEST);
		}
		if (password.equals(null) || password.equals("")) {
			return new ResponseEntity<String>("Enter Password.... ",HttpStatus.BAD_REQUEST);
			}
		Seller seller = sellerrepo.validate(username, password);
		if (seller != null) {
			return new ResponseEntity<String>("Successfully Login!!",HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Login Failed..Retry Again with Valid Credentials",HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<String> sellerApproval(Long sellerId) {
		Seller entity = sellerrepo.findById(sellerId).get();
		entity.setIsApproved("Yes");
		sellerrepo.save(entity);
		return new ResponseEntity("Seller Approved", HttpStatus.OK);
		}
	
	public ResponseEntity<String> orderApproval(Long placeOrderId) {
		PlaceOrder order = placeorderrepo.findById(placeOrderId).get();
		order.setOrderStatus("Order Placed");
		placeorderrepo.save(order);
		return new ResponseEntity("Your Order succesfully place", HttpStatus.OK);
		}
	
	
}
