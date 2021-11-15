package com.food.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.food.model.Order_Table;

import com.food.repository.OrderTableRepository;

@Service
public class OrderTableService {
	@Autowired
	OrderTableRepository orderTableRepository;

	public List<Order_Table> orderList() {
		List<Order_Table> order = (List<Order_Table>) orderTableRepository.findAll();
		return order;
	}

	public void orderDetails(int order_id) {
		try {

			orderTableRepository.findById(order_id);
		} catch (Exception exception) {
			System.out.println("Exception caught in orderDetails Method :" + exception);
		}
	}
}