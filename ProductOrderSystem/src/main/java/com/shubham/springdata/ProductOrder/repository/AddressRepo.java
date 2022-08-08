package com.shubham.springdata.ProductOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.springdata.ProductOrder.entities.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
