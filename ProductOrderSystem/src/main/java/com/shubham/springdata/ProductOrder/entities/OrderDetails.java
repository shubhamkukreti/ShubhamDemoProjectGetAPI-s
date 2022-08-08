package com.shubham.springdata.ProductOrder.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer orderId;
	Integer orderNumber;
	String orderName;
	Date orderedDate;
	Date orderDeliveryDate;
	Boolean orderStatus;
	
	@JsonIgnore
	@ManyToOne(optional = false)
	private Address addresses;

	public Address getAddresses() {
		return addresses;
	}

	public void setAddresses(Address addresses) {
		this.addresses = addresses;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "order_product", joinColumns = {
			@JoinColumn(name = "Order_Id", referencedColumnName = "orderId") }, inverseJoinColumns = {
					@JoinColumn(name = "product_Id", referencedColumnName = "productId") })
//	@JsonBackReference
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getOrderID() {
		return orderId;
	}

	public void setOrderID(Integer orderID) {
		this.orderId = orderID;
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Date getOrderDeliveryDate() {
		return orderDeliveryDate;
	}

	public void setOrderDeliveryDate(Date orderDeliveryDate) {
		this.orderDeliveryDate = orderDeliveryDate;
	}

	public Boolean getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

}
