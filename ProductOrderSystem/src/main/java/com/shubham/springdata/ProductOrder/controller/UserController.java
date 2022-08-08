/*
 get all users -	http://localhost:8080/getAllUsers
 create new user - 	http://localhost:8080/createUser
 get user by user ID -	http://localhost:8080/getUserById/2
 */

package com.shubham.springdata.ProductOrder.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.springdata.ProductOrder.entities.User;
import com.shubham.springdata.ProductOrder.repository.UserRepo;

@RestController
public class UserController {

	@Autowired
	UserRepo userrepo;

	@GetMapping(path = "/getAllUsers")
	public List<User> getAllUsers() {
		return userrepo.findAll();
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public User createUser(@Valid @RequestBody User user) {
		userrepo.save(user);
		return user;
	}

	@RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
	public Optional<User> getUserById(@PathVariable(value = "id") Integer userID) {
		Optional<User> user = userrepo.findById(userID);
		return user;
	}
}
