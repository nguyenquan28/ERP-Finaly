package com.Exam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exam.DAO.StoreDAO;
import com.Exam.Entity.Store;

@Service
public class StoreService {
	
	@Autowired
	StoreDAO storeDAO;
	
//	Show all Store
	public List<Store> showStore(){
		return storeDAO.findAll();
	}
}
