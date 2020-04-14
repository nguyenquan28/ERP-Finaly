package com.Exam.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Exam.DAO.SalesCodeDAO;
import com.Exam.Entity.SalesCode;

@Service
public class SalesCodeService {

	@Autowired
	SalesCodeDAO codeDAO;
	
//	Show sale code
	public List<SalesCode> ShowAll(){
		return codeDAO.findAll();
	}
	
}
