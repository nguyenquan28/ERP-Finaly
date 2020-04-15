package com.Exam.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Exam.Entity.Orders;

@Repository
public interface OrderDAO extends JpaRepository<Orders	, Integer>{

}
