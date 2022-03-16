package com.wtc.induction.orderinfo.service;

import java.util.List;

import com.wtc.induction.orderinfo.model.OrderDetails;

public interface OrderService {

	public  OrderDetails getOrderDetailsbyId(Integer id);
	
	public List<OrderDetails> getAllOrders();
	
	public OrderDetails saveOrder(OrderDetails order);
}
