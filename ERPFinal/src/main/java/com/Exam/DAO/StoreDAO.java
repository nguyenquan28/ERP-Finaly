package com.Exam.DAO;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Exam.Entity.Store;

@Repository
public interface StoreDAO extends JpaRepository<Store, Integer>{

}
