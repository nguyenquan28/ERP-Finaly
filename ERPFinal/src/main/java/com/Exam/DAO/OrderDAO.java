package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.Orders;

@Transactional
public interface OrderDAO extends JpaRepository<Orders, Integer> {

}
