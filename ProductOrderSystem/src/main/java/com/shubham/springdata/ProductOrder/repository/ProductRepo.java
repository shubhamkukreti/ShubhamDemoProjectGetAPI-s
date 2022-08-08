package com.shubham.springdata.ProductOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.springdata.ProductOrder.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
