
/*find all Addresses -	http://localhost:8080/getAllAddresses
find address by address ID -	http://localhost:8080/getAddressById/2
*/

package com.shubham.springdata.ProductOrder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.springdata.ProductOrder.entities.Address;
import com.shubham.springdata.ProductOrder.repository.AddressRepo;

@RestController
public class AddressController {

	@Autowired
	AddressRepo addressrepo;

	@GetMapping(path = "/getAllAddresses")
	public List<Address> getAllAddresses() {
		return addressrepo.findAll();
	}

	@GetMapping(path = "/getAddressById/{id}")
	public Optional<Address> getUserForAddress(@PathVariable(value = "id") Integer addressId) {
		Optional<Address> add = addressrepo.findById(addressId);
		return add;
	}

}
