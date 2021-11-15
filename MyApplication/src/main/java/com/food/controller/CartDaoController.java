package com.food.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.food.model.Cart_Table;
import com.food.model.Menu_Table;

import com.food.model.User_Table;
import com.food.repository.CartRepository;
import com.food.repository.MenuRepository;
import com.food.services.CartService;
import com.food.services.UserTableService;

@Controller
@RequestMapping("/user")
public class CartDaoController {
	@Autowired
	UserTableService userTableService;

	@Autowired
	CartService cartService;

	@Autowired
	MenuRepository menurepo;
	@Autowired
	CartRepository cartrepo;
	
	@PostMapping(value = "addcart/{dishName}")
	public String addCart(@PathVariable("dishName") String dishName, Model model) {
		System.out.println(dishName);
		Menu_Table menu = menurepo.findById(dishName).get();
		model.addAttribute("menu", menu);
		return "addcart";
	}

	@RequestMapping(value = "/saveToCart/{dishName}", method = RequestMethod.POST)
	public ModelAndView saveCart(@PathVariable("dishName") String dishName, int quantity,
			@SessionAttribute("user") User_Table user) {

		Menu_Table menu_table = userTableService.findUserById(String.valueOf(dishName));

		ModelAndView model1 = new ModelAndView("mycart");

		try {
			if (quantity > menu_table.getAvailable_Quantity()) {

				model1.addObject("msg", " Please enter lesser quantity " + " The available quantity is "
						+ menu_table.getAvailable_Quantity());
				return model1;
			}
			List<Cart_Table> cartAllList = new ArrayList<Cart_Table>();
			List<Cart_Table> cartUserList = new ArrayList<Cart_Table>();
			LocalDate date = LocalDate.now();
			String found = null;
			Menu_Table dishDetails = new Menu_Table();
			cartAllList = (List<Cart_Table>) cartrepo.findAll();
			for (var cart : cartAllList) {
				if ((cart.getUser_id() == user.getUser_id())
						&& (menurepo.findById(dishName)).get().getDate_Of_Updation().equals(date.toString()))
					cartUserList.add(cart);
			}
			dishDetails = menurepo.findById(dishName).get();
			for (var cart : cartUserList) {
				if (cart.getDish_Name().equals(dishName)) {
					int quant = dishDetails.getAvailable_Quantity();
					if ((quantity + cart.getQuantity()) < dishDetails.getAvailable_Quantity())
						quant = (quantity + cart.getQuantity());
					System.out.println(quant);
					cart.setQuantity(quant);
					cart.setPrice(quant * dishDetails.getPrice());
					cartrepo.save(cart);
					found = "found";
					break;
				}
			}
			if (found == null) {
				Cart_Table cartDetails = new Cart_Table();
				cartDetails.setUser_id(user.getUser_id());
				cartDetails.setDish_Name(dishDetails.getDish_Name());
				cartDetails.setDish_img(dishDetails.getDish_img());
				int quant = quantity;
				if (quantity > dishDetails.getAvailable_Quantity())
					quant = dishDetails.getAvailable_Quantity();
				else if (quantity < 1)
					quant = 1;
				System.out.println(quant);
				cartDetails.setQuantity(quant);
				cartDetails.setPrice(quant * dishDetails.getPrice());
				cartrepo.save(cartDetails);
			}

			cartAllList = (List<Cart_Table>) cartrepo.findAll();
			List<Cart_Table> cartList = new ArrayList<Cart_Table>();
			for (var cart : cartAllList) {
				if ((cart.getUser_id() == user.getUser_id())
						&& (menurepo.findById(dishName)).get().getDate_Of_Updation().equals(date.toString()))
					cartList.add(cart);
			}
			model1.addObject("cart", cartList);
			float totalPrice = 0;
			for (var cart : cartList) {
				totalPrice = totalPrice + (cart.getPrice());
			}
			model1.addObject("totalPrice", totalPrice);
		} catch (Exception exception) {
			System.out.println("Exception caught in savetoorder1 Method :" + exception);
		}
		return model1;
	}
	@RequestMapping("/getcart")
	public ModelAndView cart(@SessionAttribute("user") User_Table user) {
		List<Cart_Table> cartAllList = new ArrayList<Cart_Table>();
		ModelAndView model = new ModelAndView("mycart");
		try {
			List<Cart_Table> cartUserList = new ArrayList<Cart_Table>();
			LocalDate date = LocalDate.now();
			cartAllList = (List<Cart_Table>) cartrepo.findAll();
			for (var cart : cartAllList) {
				if ((cart.getUser_id() == user.getUser_id())
						&& (menurepo.findById(cart.getDish_Name())).get().getDate_Of_Updation().equals(date.toString()))
					cartUserList.add(cart);
			}

			float totalPrice = 0;
			model.addObject("cart", cartUserList);
			for (var cart : cartUserList) {
				totalPrice = totalPrice + (cart.getPrice());
			}
			model.addObject("totalPrice", totalPrice);
		} catch (Exception exception) {
			System.out.println("Exception caught in savetoorder1 Method :" + exception);
		}
		return model;
	}



	@RequestMapping("/editCartQuantOpr/{cart_id}/{dish_name}")
	public ModelAndView editCartOperation(@RequestParam int quantity, @PathVariable("cart_id") int cart_id,
			@PathVariable("dish_name") String dish_name, @SessionAttribute("user") User_Table user) {
		ModelAndView model = new ModelAndView("mycart");
		try {
			float totalPrice = 0;
			Menu_Table dishMenu = menurepo.findById(dish_name).get();

			if ((dishMenu.getAvailable_Quantity() >= quantity) && (quantity > 0)) {
				Cart_Table cartDetails = cartrepo.findById(cart_id).get();
				cartDetails.setQuantity(quantity);
				cartDetails.setPrice(dishMenu.getPrice() * quantity);
				cartrepo.save(cartDetails);
				model.addObject("msd", "Quantity Successfully Updated");
			} else
				model.addObject("msd", "Quantity Not Updated Out of Range");
			List<Cart_Table> cartList = (List<Cart_Table>) cartrepo.findAll();
			LocalDate date = LocalDate.now();
			List<Cart_Table> cartList1 = new ArrayList<Cart_Table>();
			for (var cart : cartList) {
				if ((cart.getUser_id() == user.getUser_id())
						&& (menurepo.findById(cart.getDish_Name()).get().getDate_Of_Updation().equals(date.toString())))
					cartList1.add(cart);
			}
			for (var cart : cartList1)
				totalPrice = totalPrice + cart.getPrice();
			model.addObject("cart", cartList1);
			model.addObject("totalPrice", totalPrice);
			model.addObject("path", "../../../Images/");
		} catch (Exception exception) {
			System.out.println("Exception caught in editCartOperation Method :" + exception);
		}
		return model;
	}

	@RequestMapping("/edit/{cart_id}")
	public ModelAndView editCartTable(@PathVariable("cart_id") int cart_id) {
		ModelAndView model = new ModelAndView("editCartQuantTable");
		try {
			Cart_Table cartDetails = cartrepo.findById(cart_id).get();

			model.addObject("list", cartDetails);
			model.addObject("quantDetails",
					menurepo.findById(cartDetails.getDish_Name()).get().getAvailable_Quantity());
			model.addObject("path", "../../Images/");
		} catch (Exception exception) {
			System.out.println("Exception caught in editCartTable Method :" + exception);
		}
		return model;
	}

	
	
	@PostMapping("/remove/{cart_id}")
	public String removeCart(Model model, @PathVariable("cart_id") int cart_id) {
		System.out.println("start remove");
		cartService.removefromcart(cart_id);
		System.out.println("Deleted");
		return ("redirect:/user/getcart");
	}
}