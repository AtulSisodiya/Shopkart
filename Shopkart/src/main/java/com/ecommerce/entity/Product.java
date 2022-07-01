package com.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String productName;
	private String brand;
	private int quantity;
	private String description;
	private String productPrice;
	private Long sellerId;
	
    @ManyToOne
	Category category;
	
	
	public Product() {
		
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}


	public Long getSellerId() {
		return sellerId;
	}


	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	@JsonBackReference
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brand=" + brand + ", quantity="
				+ quantity + ", description=" + description + ", productPrice=" + productPrice + ", sellerId="
				+ sellerId + ", category=" + category + "]";
	}


	public Product(Long productId, String productName, String brand, int quantity, String description,
			String productPrice, Long sellerId, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.quantity = quantity;
		this.description = description;
		this.productPrice = productPrice;
		this.sellerId = sellerId;
		this.category = category;
	}
	

	

	
	
}
