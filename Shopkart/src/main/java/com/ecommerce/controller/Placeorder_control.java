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
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.PlaceOrder;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.Wallet;
import com.ecommerce.repo.BuyerRepo;
import com.ecommerce.repo.PlaceOrderRepo;
import com.ecommerce.repo.ProductRepo;
import com.ecommerce.repo.WalletRepo;

@RestController
@RequestMapping("/placeorder")
public class Placeorder_control {

	@Autowired
	PlaceOrderRepo po;
	
	@Autowired
	ProductRepo pr;
	@Autowired
	BuyerRepo br;
	
	@Autowired
	WalletRepo wr;
	
	
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
	
	@GetMapping("/invoice")
	public String getInvoice(@RequestParam Long buyerId,Integer walletId) {
		int sum=0;
		Wallet w=wr.findById(walletId).get();
		Buyer b =br.findById(buyerId).get();
		
		
		int walletb =(int) w.getBalance();

		List<Cart> cr =b.getCart();
		for(Cart c:cr) {
		List<Product> pro=c.getProduct();
		for(Product p:pro) {
			
		sum+=Integer.parseInt(p.getProductPrice());
		}
		}
		if(sum>walletb) {
			return "Wallet limit reached";
		}
		else
		{
			double temp=walletb-sum;
		Wallet wnew = new Wallet();
		wnew.setId(w.getId());
		wnew.setBalance(temp);
		wr.save(wnew);	
		return Integer.toString(sum)+"  Wallet amount left: "+ Integer.toString(walletb-sum);
		}	
		
	}
		
	
	}

