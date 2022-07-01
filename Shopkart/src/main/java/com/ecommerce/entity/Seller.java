package com.ecommerce.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="register_seller")
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sellerId;
	private String sellerName;
	private String username;
	private String password;
	private String isApproved; 
	private String mobileNo;
	
	
	Seller(){}


	public Long getSellerId() {
		return sellerId;
	}


	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}


	public String getSellerName() {
		return sellerName;
	}


	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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


	public String getIsApproved() {
		return isApproved;
	}


	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", username=" + username + ", password="
				+ password + ", isApproved=" + isApproved + ", mobileNo=" + mobileNo + "]";
	}


	public Seller(Long sellerId, String sellerName, String username, String password, String isApproved,
			String mobileNo) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.username = username;
		this.password = password;
		this.isApproved = isApproved;
		this.mobileNo = mobileNo;
	}

	}
