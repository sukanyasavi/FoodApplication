package com.food.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.food.model.Cart_Table;
import com.food.model.Menu_Table;
import com.food.model.Order_Table;
import com.food.model.User_Table;
import com.food.repository.CartRepository;
import com.food.repository.MenuRepository;
import com.food.repository.OrderTableRepository;
import com.food.services.CartService;
import com.food.services.OrderService;

@Controller
@RequestMapping("/user")
public class PaymentDaoController {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartService cartService;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderTableRepository orderTableRepository;

	@Autowired
	MenuRepository menuRepository;

	@RequestMapping("/addpayment")
	public ModelAndView cart(@SessionAttribute("user") User_Table user) {
		List<Cart_Table> cartList = new ArrayList<Cart_Table>();
		ModelAndView model = new ModelAndView("mycart2");
		try {
			List<Cart_Table> cartList1 = new ArrayList<Cart_Table>();
			LocalDate date = LocalDate.now();
			cartList = (List<Cart_Table>) cartRepository.findAll();
			for (var cart : cartList) {
				if ((cart.getUser_id() == user.getUser_id()) && (menuRepository.findById(cart.getDish_Name())).get()
						.getDate_Of_Updation().equals(date.toString()))
					cartList1.add(cart);
			}

			float totalPrice = 0;
			model.addObject("cart", cartList1);
			for (var cart : cartList1) {
				totalPrice = totalPrice + (cart.getPrice());
			}
			model.addObject("totalPrice", totalPrice);
		} catch (Exception exception) {
			System.out.println("Exception caught in addpayment Method :" + exception);
		}

		return model;
	}

	@RequestMapping("/billing")
	public String billing() {
		return "payment";
	}

	@RequestMapping(value = "/saveToOrder1")
	public String saveorder1(@SessionAttribute("user") User_Table user, User_Table user_table) {
		List<Cart_Table> cartList = new ArrayList<Cart_Table>();
		try {
			List<Cart_Table> cartList1 = new ArrayList<Cart_Table>();

			cartList = (List<Cart_Table>) cartRepository.findAll();
			LocalDate date = LocalDate.now();
			for (var cart : cartList) {
				if ((cart.getUser_id() == user.getUser_id()) && (menuRepository.findById(cart.getDish_Name()).get()
						.getDateOfUpdation().equals(date.toString())))
					cartList1.add(cart);

			}
			for (var cart : cartList1) {
				Order_Table o = new Order_Table();
				o.setName(user_table.getUser_name());
				o.setAddress(user_table.getAddress());
				o.setPhone_no(user_table.getPh_number());
				o.setMode_of_payment("COD");
				o.setDate_of_order(date.toString());
				o.setDish_Name(cart.getDish_Name());
				o.setDish_img(cart.getDish_img());
				o.setPrice(cart.getPrice());
				o.setQuantity(cart.getQuantity());
				o.setUser_id(user.getUser_id());
				orderTableRepository.save(o);

				Menu_Table menu = menuRepository.findById(cart.getDish_Name()).get();
				menu.setAvailable_Quantity(menu.getAvailable_Quantity() - cart.getQuantity());
				menuRepository.save(menu);
				cartRepository.deleteById(cart.getCart_id());

			}
		} catch (Exception exception) {
			System.out.println("Exception caught in savetoorder1 Method :" + exception);
		}
		return "ordersuccess";
	}

}
