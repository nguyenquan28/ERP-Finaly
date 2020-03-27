package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Exam.Entity.Store;

@Transactional
public interface StoreDAO extends JpaRepository<Store, Integer>{

}
