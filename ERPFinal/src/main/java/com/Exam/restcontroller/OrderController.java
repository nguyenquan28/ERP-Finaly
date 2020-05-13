package com.Exam.restcontroller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.Exam.DAO.SearchOrderDAO;
import com.Exam.Entity.OrderItem;
import com.Exam.Entity.Orders;
import com.Exam.dto.OrderDTO;
import com.Exam.dto.OrderItemDTO;
import com.Exam.Service.MailService;
import com.Exam.Service.OrderService;
import com.Exam.Service.ReadNumberService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	//get all data order
	@Autowired
	ReadNumberService read;
	@Autowired MailService mail;
	
	
	
	
	@RequestMapping(value = "/admin/getAllOrder"  )
	public List<OrderDTO> getAllOrder(@RequestParam(name = "page-number")int pageNumber){										
		return orderService.getAllOrder(pageNumber);
	}
	@RequestMapping(value = "/api/list-chua-thanh-toan" )
	public List<OrderDTO> getListUnpaid(@RequestParam(name = "page-number")int pageNumber){										
		return orderService.listOrderUnPaid(pageNumber);
	}
	
	@RequestMapping(value="/api/tim-khach-hang-chua-thanh-toan")
	public List<OrderDTO> timKhachChuaThanhToan(@RequestParam(name = "q")String q){
		
		return orderService.chuathanhtoan(q);
	}
	
	@RequestMapping(value = "/api/last-page")
	public int demDanhSachChuaThanhToan(){	
		int i = orderService.demDanhSachChuaThanhToan();
		if (i%5 == 0) {
			return (i/5)-1;
		}
		return i/5;
		
	}
	
	@RequestMapping(value ="/api/search")
	public List<OrderDTO> searchResult(@RequestParam(name = "q")String q , @RequestParam(name="pageNumber")int pageNumber){
		
		List<OrderDTO>list = orderService.search(q, pageNumber);
		
		if(list.size() != 0) {
			return list;
		}
		return null;
		
		
	}
	@RequestMapping(value ="/api/last-page-search-result")
	public int searchResultCount(@RequestParam(name = "q")String q){
		int searchResultCount = orderService.searchResultCount(q);
		if (searchResultCount%5 == 0) {
			return searchResultCount-1;
		}
		return (searchResultCount/5)-1;
		
	}
	@RequestMapping(value = "/admin/last-page")
	public int getPageCount(){	
		int i = orderService.pageCount();
		if (i%5 == 0) {
			return (i/5)-1;
		}
		return i/5;
	}
	
	@RequestMapping(value = "/admin/getOrderItem")
	public List<OrderItemDTO> getAllOrderItems(@RequestParam(value = "id") Integer id ){										
		return orderService.getOrderItemByOrderId(id);
	}
	@RequestMapping(value = "/admin/deleteOneOrderById")
	public boolean deleteOneOrderById(@RequestParam(value = "id") Integer id) {
		orderService.deleteOneOrderById(id);
		return true;
	}
	
	@RequestMapping(value="/api/goi-mail-thu-no")
	public boolean goiMail (@RequestParam(value="id") int id) throws IOException {
		
		
		
		OrderDTO orderDTO = this.orderService.getOrderByOrderId(id);
		List<OrderItemDTO>itemDTOs = orderDTO.getOrderItems();
		DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
		
		int sum = (int) itemDTOs.stream().mapToDouble(i->i.getThanhTien()).sum();
		
		
		Context context = new Context();
		context.setVariable("listItemDTO", itemDTOs);
		context.setVariable("tenKH", orderDTO.getTenKH());
		
		context.setVariable("tongTien", df2.format(sum));
		context.setVariable("tongTienBangChu", this.read.docSo(sum));				
		this.mail.send(orderDTO.getEmail(),"Thư đòi nợ","mailthuno", context);
		
		
		return true;
	}
	@RequestMapping(value="/api/cap-nhap-don-hang")
	public void updateOrder(@RequestParam(value="id")int id,@RequestParam(value="trangthai")String trangthai ) {
		this.orderService.updateOrder(id, trangthai);
	}
}
