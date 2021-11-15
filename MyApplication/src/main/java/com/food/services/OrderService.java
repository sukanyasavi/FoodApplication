package com.food.services;

import java.util.List;

import com.food.model.Order_Table;

public interface OrderService {

	public void addToOrder(Order_Table order);

	public List<Order_Table> FetchMyOrder();

}
