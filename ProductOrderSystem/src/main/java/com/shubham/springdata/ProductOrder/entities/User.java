package com.shubham.springdata.ProductOrder.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Integer user_Id;
	String firstName;
	String lastName;
	String userEmail;
	
	@OneToMany(mappedBy = "user")
	private List<Address> adresses;
	
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public List<Address> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Address> adresses) {
		this.adresses = adresses;
	}
	

}
