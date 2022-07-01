package com.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="wallet")
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int balance;
	
	@OneToOne
	Buyer buyers;
	
	public Wallet() {
		
	}

	public Wallet(int id, int balance, Buyer buyers) {
		super();
		this.id = id;
		this.balance = balance;
		this.buyers = buyers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Buyer getBuyers() {
		return buyers;
	}

	public void setBuyers(Buyer buyers) {
		this.buyers = buyers;
	}

	@Override
	public String toString() {
		return "Wallet [id=" + id + ", balance=" + balance + ", buyers=" + buyers + "]";
	}

	
	
	
}
