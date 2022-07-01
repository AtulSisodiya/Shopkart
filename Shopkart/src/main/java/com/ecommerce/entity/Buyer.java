package com.ecommerce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="register_buyer")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long buyerId;
	
	private String buyerName;
	private String username;
	private String password;
	private String mobileNo;
	private Double wallet;
	
	@OneToMany(mappedBy = "buyerDetail")
	private List<PlaceOrder> placeorder;
	
	@OneToMany(mappedBy = "buyer")
	private List<Cart> cart;
	
	public Buyer() {
		
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}
	@JsonManagedReference
	public List<PlaceOrder> getPlaceorder() {
		return placeorder;
	}

	public void setPlaceorder(List<PlaceOrder> placeorder) {
		this.placeorder = placeorder;
	}
	@JsonManagedReference
	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public Buyer(Long buyerId, String buyerName, String username, String password, String mobileNo, Double wallet,
			List<PlaceOrder> placeorder, List<Cart> cart) {
		super();
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.username = username;
		this.password = password;
		this.mobileNo = mobileNo;
		this.wallet = wallet;
		this.placeorder = placeorder;
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Buyer [buyerId=" + buyerId + ", buyerName=" + buyerName + ", username=" + username + ", password="
				+ password + ", mobileNo=" + mobileNo + ", wallet=" + wallet + ", placeorder=" + placeorder + ", cart="
				+ cart + "]";
	}

	
	
}
