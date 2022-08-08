package com.shubham.springdata.ProductOrder;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shubham.springdata.ProductOrder.entities.Address;
import com.shubham.springdata.ProductOrder.entities.OrderDetails;
import com.shubham.springdata.ProductOrder.entities.Product;
import com.shubham.springdata.ProductOrder.entities.User;
import com.shubham.springdata.ProductOrder.repository.AddressRepo;
import com.shubham.springdata.ProductOrder.repository.OrderRepo;
import com.shubham.springdata.ProductOrder.repository.ProductRepo;
import com.shubham.springdata.ProductOrder.repository.UserRepo;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProductOrderSystemApplicationTests {
	
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	AddressRepo addressrepo;
	
	@Autowired
	ProductRepo prodRep;
	
	@Autowired
	OrderRepo ordRep;

	@Test
	void insertUser() {
		
		User user = new User();
		
		user.setFirstName("Shubham");
		user.setLastName("Kukreti");
		user.setUserEmail("kukreti@gmail.com");		
		
		userrepo.save(user);
		
	}
	
	@Test
	void insertAddress() {
		
		Address address = new Address();
		
		address.setAddressType("Office");
		address.setStreetNo(45);
		address.setCompleteAddress("It Park");
		address.setDistrict("Dehradun");
		address.setState("Uttrakhand");
		
		User user = userrepo.findById(1).get();
		address.setUser(user);
		
		addressrepo.save(address);
		
	}
	
	
	@Test
	void insertProduct() {
		
		Product prod = new Product();
		
		prod.setProductCost(2000.00);
		prod.setProductID(101);
		prod.setProductName("Tshirt");
		prod.setProductNumber(112145);
		
		Product prod1 = new Product();
		
		prod1.setProductCost(5999.99);
		prod1.setProductID(102);
		prod1.setProductName("Jeans");
		prod1.setProductNumber(425689);
		
		Product prod2 = new Product();
		
		prod2.setProductCost(85000.00);
		prod2.setProductID(1003);
		prod2.setProductName("Iphone");
		prod2.setProductNumber(125681);
		
		Product prod3 = new Product();
		
		prod3.setProductCost(999.00);
		prod3.setProductID(104);
		prod3.setProductName("Toy");
		prod3
		.setProductNumber(6546545);
		
		prodRep.save(prod);
		prodRep.save(prod1);
		prodRep.save(prod2);
		prodRep.save(prod3);
		
	}
	
	@Test
	void createOrder() throws ParseException {
		
		OrderDetails ordDetails = new OrderDetails();
		
		String ordDate="2/03/2022";  
	    Date orderDate = new SimpleDateFormat("dd/MM/yyyy").parse(ordDate);	    
	    
	    String delDate="25/05/2022";  
	    Date deliverDate = new SimpleDateFormat("dd/MM/yyyy").parse(delDate);
		
		ordDetails.setOrderName("All Items");
		ordDetails.setOrderNumber(1005);
		ordDetails.setOrderStatus(false);
		ordDetails.setOrderedDate(orderDate);
		ordDetails.setOrderDeliveryDate(deliverDate);
		
		Address address = addressrepo.findById(1).get();
		ordDetails.setAddresses(address);
		
		
		Product product1 = prodRep.findById(1).get();
//		Product product3 = prodRep.findById(2).get();
		Product product2 = prodRep.findById(3).get();
		List<Product> prd1 = Arrays.asList(product1, product2);
		ordDetails.setProducts(prd1);
		ordRep.save(ordDetails);
		
	}
	

}
