package com.ecommerce.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.request.OrderRequest;
import com.ecommerce.project.response.OrderResponse;
import com.ecommerce.project.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("all")
	public List<OrderResponse> findAllOrders(){
		return orderService.findAllOrder();
	}
	
	@GetMapping("/{id}")
	public OrderResponse findOrder(@RequestParam int id) {
		return orderService.findOrderById(id);
	}

	@PostMapping()
	public String addProductItems(@RequestBody OrderRequest req) {
		return orderService.addOrder(req);
	}
	
	@GetMapping("/pagination")
	public Page<OrderResponse> orderList(@RequestParam int pageNo, @RequestParam int noOfContent){
		return orderService.orderPagable(pageNo,noOfContent);
	}
	
	
	
}
