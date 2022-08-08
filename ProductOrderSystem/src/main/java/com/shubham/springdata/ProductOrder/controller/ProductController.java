/*
 get all products -	http://localhost:8080/getAllProducts
 get product by product id -	http://localhost:8080/getOrderDetailsByPId/3
 */

package com.shubham.springdata.ProductOrder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.springdata.ProductOrder.entities.Product;
import com.shubham.springdata.ProductOrder.repository.ProductRepo;

@RestController
public class ProductController {

	@Autowired
	ProductRepo prodRepo;

	@GetMapping(path = "/getAllProducts")
	public List<Product> getAllProducts() {
		return prodRepo.findAll();
	}

	@RequestMapping(value = "/getOrderDetailsByPId/{id}", method = RequestMethod.GET)
	Optional<Product> getOrderDetailsByPId(@PathVariable(value = "id") Integer productId) {
		return prodRepo.findById(productId);
	}

}
