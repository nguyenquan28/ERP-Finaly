package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.Discount;

@Transactional
public interface DiscountDAO extends JpaRepository<Discount, Integer>{

}
