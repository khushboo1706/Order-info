package com.wtc.induction.orderinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wtc.induction.orderinfo.model.OrderDetails;
import com.wtc.induction.orderinfo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("getOrder/{id}")
    public OrderDetails getOrderbyId(@PathVariable int id) {
        return orderService.getOrderDetailsbyId(id);
    }
	
	@GetMapping("getAllOrders")
    public List<OrderDetails> getAllOrders() {
        return orderService.getAllOrders();
    }
	
	@PostMapping("saveOrder")
    public OrderDetails saveOrder(@RequestBody OrderDetails order) {
		System.out.println("order Service");
        return orderService.saveOrder(order);
    }

}
