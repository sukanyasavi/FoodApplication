package com.food.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.food.model.Order_Table;
import com.food.model.User_Table;
import com.food.repository.OrderTableRepository;
import com.food.services.OrderTableService;

@Controller
@RequestMapping("/user")
public class OrderDaoController {
	@Autowired
	OrderTableService orderTableService;
	@Autowired
	OrderTableRepository orderTableRepository;

	@RequestMapping(value = "/myOrder")
	public ModelAndView myOrder(@SessionAttribute("user") User_Table user) {
		int id = user.getUser_id();
		ModelAndView model = new ModelAndView("myOrder");
		try {
			List<Order_Table> order = orderTableService.orderList();
			List<Order_Table> order1 = new ArrayList<Order_Table>();

			for (var list : order) {
				if (list.getUser_id() == id) {
					order1.add(list);
				}
			}

			List<Order_Table> order2 = new ArrayList<Order_Table>();
			int x = 0;

			for (int j = order1.size() - 1; j >= 0; j--) {
				order2.add(order1.get(j));
				if (++x > 4)
					break;
			}
			model.addObject("Items", order2);
			if (order2.isEmpty()) {
				model.addObject("msg", "***************NO ORDERS*************** ");
			}
		} catch (Exception exception) {
			System.out.println("Exception caught in myOrder method" + exception);
		}
		return model;
	}

	@RequestMapping(value = "/myOrderDetails")
	public ModelAndView myOrderDetails(@SessionAttribute("user") User_Table user) {
		ModelAndView model = new ModelAndView("myOrderDetails");
		int id = user.getUser_id();
		try {
			List<Order_Table> order = orderTableService.orderList();
			List<Order_Table> order1 = new ArrayList<Order_Table>();
			for (var l : order) {
				if (l.getUser_id() == id) {
					order1.add(l);
				}
			}
			List<Order_Table> order2 = new ArrayList<Order_Table>();
			int x = 0;
			for (int j = order1.size() - 1; j >= 0; j--) {
				order2.add(order1.get(j));
				if (++x > 4)
					break;
			}
			model.addObject("Items", order2);
			if (order2.isEmpty()) {
				model.addObject("msg", "***************NO ORDERS*************** ");
			}
		} catch (Exception exception) {
			System.out.println("Exception caught in myOrderDetails method:" + exception);
		}

		return model;
	}

	@PostMapping(value = "/specificOrder/{order_id}")
	public ModelAndView specificOrders(@PathVariable("order_id") int ord_id) {

		ModelAndView model = new ModelAndView("myOrderDetails");
		try {
			List<Order_Table> order = orderTableService.orderList();
			List<Order_Table> order1 = new ArrayList<Order_Table>();
			for (var l : order) {
				if (l.getOrder_id() == ord_id) {
					order1.add(l);
				}
			}
			float totalPrice = 0;
			model.addObject("Items", order1);
			for (var orders : order1) {
				totalPrice = totalPrice + (orders.getPrice());
			}
			model.addObject("totalPrice", totalPrice);

			if (order1.isEmpty()) {
				model.addObject("msg", "***************NO ORDERS*************** ");
			}
		} catch (Exception exception) {
			System.out.println("Exception caught in myOrderDetails method:" + exception);
		}

		return model;
	}

}