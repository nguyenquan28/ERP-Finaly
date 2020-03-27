package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.SalesCode;

@Transactional
public interface SalesCodeDAO extends JpaRepository<SalesCode, Integer>{

}
