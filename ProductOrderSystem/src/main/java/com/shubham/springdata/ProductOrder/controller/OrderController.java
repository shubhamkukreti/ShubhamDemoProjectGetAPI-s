
/*find all orders -	http://localhost:8080/getAllOrders
get order by order id -	 http://localhost:8080/getOrderById/3
get order by delivery status -	http://localhost:8080/getOrderByDelStatus/0
get order by ordered date - 	http://localhost:8080/getOrderByDate/01-03-2022
*/



package com.shubham.springdata.ProductOrder.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.springdata.ProductOrder.entities.OrderDetails;
import com.shubham.springdata.ProductOrder.repository.OrderRepo;

@RestController
public class OrderController {
	
	@Autowired
	OrderRepo ordRepo;

	@GetMapping(path = "/getAllOrders")
	public List<OrderDetails> getAllOrders() {
		return ordRepo.findAll();
	}
	
	@GetMapping(path = "getOrderById/{id}")
	public Optional<OrderDetails> getOrderById(@PathVariable(value = "id") Integer orderID){
		return ordRepo.findById(orderID);
	}
	
	@GetMapping(path = "/getOrderByDelStatus/{id}")
	public List<OrderDetails> getOrderByDelStatus(@PathVariable(value = "id") Integer delStatus) {
		return ordRepo.findByDeliveryStatus(delStatus);
	}
	
	@GetMapping(path = "/getOrderByDate/{date}")
	public List<OrderDetails> getOrderByDate(@PathVariable(value = "date") String date) throws ParseException {
		
		Date deliverDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);

		return ordRepo.findOrderByDate(deliverDate);
	}
}
