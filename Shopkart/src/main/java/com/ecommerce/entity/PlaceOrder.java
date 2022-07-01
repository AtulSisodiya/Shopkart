package com.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="place_order")
public class PlaceOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long placeOrderId;
	
	private String address;
	private String state;
	private String city;
	private String pincode;
	private String orderStatus;
	private long buyerId;
	
	@ManyToOne
	Buyer buyerDetail;
	
	public PlaceOrder() {
		
	}

	public PlaceOrder(Long placeOrderId, String address, String state, String city, String pincode, String orderStatus,
			long buyerId, Buyer buyerDetail) {
		super();
		this.placeOrderId = placeOrderId;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.orderStatus = orderStatus;
		this.buyerId = buyerId;
		this.buyerDetail = buyerDetail;
	}

	public Long getPlaceOrderId() {
		return placeOrderId;
	}

	public void setPlaceOrderId(Long placeOrderId) {
		this.placeOrderId = placeOrderId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(long buyerId) {
		this.buyerId = buyerId;
	}
    @JsonBackReference
	public Buyer getBuyerDetail() {
		return buyerDetail;
	}

	public void setBuyerDetail(Buyer buyerDetail) {
		this.buyerDetail = buyerDetail;
	}

	@Override
	public String toString() {
		return "PlaceOrder [placeOrderId=" + placeOrderId + ", address=" + address + ", state=" + state + ", city="
				+ city + ", pincode=" + pincode + ", orderStatus=" + orderStatus + ", buyerId=" + buyerId
				+ ", buyerDetail=" + buyerDetail + "]";
	}

	
}
