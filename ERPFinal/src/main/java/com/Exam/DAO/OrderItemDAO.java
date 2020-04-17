package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.OrderItem;
@Transactional
public interface OrderItemDAO extends JpaRepository<OrderItem, Integer>{

}
