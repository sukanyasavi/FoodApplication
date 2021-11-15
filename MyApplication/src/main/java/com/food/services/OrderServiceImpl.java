package com.food.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.model.Order_Table;
import com.food.repository.OrderTableRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderTableRepository orderRepository;

	@Override
	public void addToOrder(Order_Table order) {
		try {
			orderRepository.save(order);

		} catch (Exception exception) {
			System.out.println("Exception caught in addToOrder Method :" + exception);
		}
	}

	@Override
	public List<Order_Table> FetchMyOrder() {
		List<Order_Table> u = (List<Order_Table>) orderRepository.findAll();
		return u;
	}

}
