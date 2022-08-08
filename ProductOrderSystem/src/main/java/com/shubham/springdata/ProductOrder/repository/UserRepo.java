package com.shubham.springdata.ProductOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.springdata.ProductOrder.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
