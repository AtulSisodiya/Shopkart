package com.ecommerce.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;
	
	@ManyToOne
	Buyer buyer;
	
	@ManyToMany
	List <Product> product;

	Cart(){}
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	@JsonBackReference
	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Cart(Long cartId, Buyer buyer, List<Product> product) {
		super();
		this.cartId = cartId;
		this.buyer = buyer;
		this.product = product;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", buyer=" + buyer + ", product=" + product + "]";
	}
	
	
	
	
}
