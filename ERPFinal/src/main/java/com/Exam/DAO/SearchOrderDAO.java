package com.Exam.DAO;

import java.util.List;

import com.Exam.Entity.Orders;

public interface SearchOrderDAO {
		
		public List<Orders> search(String q,int pageNumber);
		
		public int searchResultCount(String q);
		
		public List<Orders> timKhachHangChuaThanhToan(String q);
}
