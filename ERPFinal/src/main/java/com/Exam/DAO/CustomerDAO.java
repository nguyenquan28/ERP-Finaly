package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Exam.Entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{
	@Query(value ="select * from customer c where c.maKH  = :id", nativeQuery = true)
	public Customer getCustomerById(@Param(value = "id")int id);
}
