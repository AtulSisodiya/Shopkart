package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Admin;
import com.ecommerce.entity.Buyer;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.PlaceOrder;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.Seller;
import com.ecommerce.repo.AdminRepo;
import com.ecommerce.repo.BuyerRepo;
import com.ecommerce.repo.CartRepo;
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

	@Autowired
	CartRepo cartrepo;

//---------------------login admin------------------
	public ResponseEntity<String> loginAdmin(String username, String password) {
		if (username.equals(null) || username.equals("")) {
			return new ResponseEntity<String>("Enter Username.... ", HttpStatus.BAD_REQUEST);
		}
		if (password.equals(null) || password.equals("")) {
			return new ResponseEntity<String>("Enter Password.... ", HttpStatus.BAD_REQUEST);
		}
		Admin seller = adminRepo.validate(username, password);
		if (seller != null) {
			return new ResponseEntity<String>("Successfully Login!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Login Failed..Retry Again with Valid Credentials",
					HttpStatus.BAD_REQUEST);
		}
	}

	// ------------------------buyer login----------------------
	public ResponseEntity<String> loginbuyer(String username, String password) {
		if (username.equals(null) || username.equals("")) {
			return new ResponseEntity<String>("Enter Username.... ", HttpStatus.BAD_REQUEST);
		}
		if (password.equals(null) || password.equals("")) {
			return new ResponseEntity<String>("Enter Password.... ", HttpStatus.BAD_REQUEST);
		}
		Buyer buyer = buyerrepo.validate(username, password);
		if (buyer != null) {
			return new ResponseEntity<String>("Successfully Login!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Login Failed..Retry Again with Valid Credentials",
					HttpStatus.BAD_REQUEST);
		}
	}

	// ---------------------login seller---------------------------
	public ResponseEntity<String> loginseller(String username, String password) {
		if (username.equals(null) || username.equals("")) {
			return new ResponseEntity<String>("Enter Username.... ", HttpStatus.BAD_REQUEST);
		}
		if (password.equals(null) || password.equals("")) {
			return new ResponseEntity<String>("Enter Password.... ", HttpStatus.BAD_REQUEST);
		}
		Seller seller = sellerrepo.validate(username, password);
		if (seller != null) {
			return new ResponseEntity<String>("Successfully Login!!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Login Failed..Retry Again with Valid Credentials",
					HttpStatus.BAD_REQUEST);
		}
	}

//-------------------Seller approve-----------------------
	public ResponseEntity<String> sellerApproval(Long sellerId) {
		Seller entity = sellerrepo.findById(sellerId).get();
		entity.setIsApproved("Yes");
		sellerrepo.save(entity);
		return new ResponseEntity("Seller Approved", HttpStatus.OK);
	}

	// ---------------Order approve------------------
	public ResponseEntity<String> orderApproval(Long placeOrderId) {
		PlaceOrder order = placeorderrepo.findById(placeOrderId).get();
		order.setOrderStatus("Order Placed");
		placeorderrepo.save(order);
		return new ResponseEntity("Your Order succesfully place", HttpStatus.OK);
	}

	// ---------------delete product in the cart------------------
	public List<Cart> deldata(long cartId, long productId) {
		Cart c = cartrepo.findById(cartId);
		Product p = productrepo.findById(productId);
		List<Product> temp = c.getProduct();
		temp.remove(p);
		cartrepo.save(c);

		return cartrepo.findAll();
	}

}
