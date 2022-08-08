package com.shubham.springdata.ProductOrder.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer productId;
	Integer productNumber;
	String productName;
	double productCost;

	@ManyToMany(mappedBy = "products")
	@JsonIgnore
//	@JsonManagedReference
	private List<OrderDetails> ordersPDetails;

	public List<OrderDetails> getOrdersPDetails() {
		return ordersPDetails;
	}

	public void setOrdersPDetails(List<OrderDetails> ordersPDetails) {
		this.ordersPDetails = ordersPDetails;
	}

	public Integer getProductID() {
		return productId;
	}

	public void setProductID(Integer productID) {
		this.productId = productID;
	}

	public Integer getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

}
