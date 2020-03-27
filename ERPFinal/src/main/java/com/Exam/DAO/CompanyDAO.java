package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.Company;

@Transactional
public interface CompanyDAO extends JpaRepository<Company, Integer>{

}
