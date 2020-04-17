package com.Exam.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Exam.Entity.OrderItem;
import com.Exam.Entity.Orders;
import com.Exam.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	//get all data order
//	@RequestMapping(value = "/admin/getAllOrder")
//	public List<Orders> getAllOrder(){
//		return orderService.getAllOrder();
//	}
	//get all data orderitem by id order
//	@RequestMapping(value = "/admin/getAllOrderItemByIdOrder")
//	public List<OrderItem> getAllOrderItemByIdOrder(@RequestParam(value = "id") Integer id){
//		return orderService.getAllOrderItemByIdOrder(id);
//		}

}
