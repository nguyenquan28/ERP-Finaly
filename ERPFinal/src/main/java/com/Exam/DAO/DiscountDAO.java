package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Exam.Entity.Discount;

@Repository
public interface DiscountDAO extends JpaRepository<Discount, Integer>{

}
