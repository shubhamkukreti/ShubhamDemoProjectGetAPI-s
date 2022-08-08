package com.shubham.springdata.ProductOrder.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer addressId;
	String addressType;
	Integer streetNo;
	String completeAddress;
	String district;
	String State;

	@JsonIgnore
	@ManyToOne(optional = false)
	private User user;

//	@ManyToMany(mappedBy = "addresses")
//	private List<OrderDetails> orderdetils;
	
	@OneToMany(mappedBy = "addresses")
	List<OrderDetails> orderdetails;

	public List<OrderDetails> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<OrderDetails> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public Integer getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(Integer streetNo) {
		this.streetNo = streetNo;
	}

	public String getCompleteAddress() {
		return completeAddress;
	}

	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
