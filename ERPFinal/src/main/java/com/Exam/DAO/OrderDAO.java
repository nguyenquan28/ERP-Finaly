package com.Exam.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.search.jpa.FullTextQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
		
		@Query(value = "select * from orders s where s.trang_thai ='Chưa thanh toán'",nativeQuery=true)
		public List<Orders> getOrdersUnPaid(Pageable pageable);
		
		@Modifying
		@Transactional
		@Query(value="update orders set trang_thai= ?2 where id =?1",nativeQuery = true)
		public void updateOrder(@Param(value="id")int id ,@Param(value="trangThai")String trangThai);
		
		@Query(value="select count(id) from orders",nativeQuery = true)
		public int pageCount();
		
		@Query(value ="select count(id) from orders where trang_thai ='Chưa thanh toán'",nativeQuery = true)
		public int listChuaThanhToanCount();
		
		
		
		
		
}
