package com.Exam.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Exam.Entity.OrderItem;
import com.Exam.Entity.Orders;
import com.Exam.dto.OrderDTO;
import com.Exam.dto.OrderItemDTO;
import com.Exam.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	//get all data order
	@RequestMapping(value = "/admin/getAllOrder")
	public List<OrderDTO> getAllOrder(){										
		return orderService.getAllOrder();
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

}
