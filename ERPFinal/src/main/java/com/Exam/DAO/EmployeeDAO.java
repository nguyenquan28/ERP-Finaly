package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.Employee;

@Transactional
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

}
