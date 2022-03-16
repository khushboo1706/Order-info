package com.wtc.induction.orderinfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wtc.induction.orderinfo.model.OrderDetails;
import com.wtc.induction.orderinfo.repo.OrderInfoRepo;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderInfoRepo orderInfoRepo;

	@Override
	public OrderDetails getOrderDetailsbyId(Integer id) {
		
		OrderDetails orderDetails= new OrderDetails();
		Optional<OrderDetails> optional= orderInfoRepo.findById(id);
		if(optional.isPresent())
		orderDetails =optional.get();//returning optional
						
		return orderDetails;
		
	}
	
	@Override
	public List<OrderDetails> getAllOrders() {
		List<OrderDetails> orderDtailsList = new ArrayList<>();
		orderDtailsList = orderInfoRepo.findAll();
		return orderDtailsList; 
		
	}
	
	@Override
	public OrderDetails saveOrder(OrderDetails order) {
		OrderDetails orderDetails = new OrderDetails();
		orderDetails=orderInfoRepo.save(order);
		System.out.println("Order Details::: "+ orderDetails.getOrderId());
			return	orderDetails; 
		
	}
}
