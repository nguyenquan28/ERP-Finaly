package com.Exam.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Exam.Entity.Orders;

@Repository
public interface OrderDAO extends JpaRepository<Orders	, Integer>{
		// bản chất của cái JpaRepository này là các hàm với mấy cái query dc viết sẵn như này , mình chỉ gọi ra thôi 
		// hieu k ? cung co hieu 1 chut
		// khi cái hàm này được gọi? nó sẽ gởi 1 câu truy vấn xuống db , các tham số sẽ được truyền theo thứ tự , thằng nào truyền vào trước thì ?1,?2 . vậy đó
		@Query(value = "select * from orders s where s.id = ?1" , nativeQuery = true)
		public Orders findOrderById(@Param(value = "id")int id);
}
