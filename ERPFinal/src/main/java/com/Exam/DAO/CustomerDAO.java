package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.Customer;

@Transactional
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
