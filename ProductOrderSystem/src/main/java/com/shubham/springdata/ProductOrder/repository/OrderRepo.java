package com.shubham.springdata.ProductOrder.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shubham.springdata.ProductOrder.entities.OrderDetails;

public interface OrderRepo extends JpaRepository<OrderDetails, Integer> {

	@Query(value = "select * from order_details where order_status = ?1", nativeQuery = true)
	List<OrderDetails> findByDeliveryStatus(Integer delStatus);

	@Query(value = "select * from order_details where ordered_date = ?1", nativeQuery = true)
	List<OrderDetails> findOrderByDate(Date deliverDate);

//	List<OrderDetails> findOrderByDate(Date orderedDate);

}
