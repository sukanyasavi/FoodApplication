//package com.food.controller;
//
//import java.time.LocalDate;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import com.food.model.Image;
//import com.food.model.Menu_Table;
//import com.food.repository.MenuRepository;
//import com.food.services.AdminUpdateService;
//
//@Controller
//public class AdminDaoController {
//	@Autowired
//	AdminUpdateService adminUpdateService;
//	@Autowired
//	MenuRepository menuRepository;
//	Image image = new Image();
//
//	@RequestMapping("/updateAdminpage")
//	public String updateAdminPage() {
//		return "UpdateAdmin";
//	}
//
//	@RequestMapping(value = "/UpdateAdmin")
//	public ModelAndView postAdminUpdate(Menu_Table adminUpdate) {
//		ModelAndView model = new ModelAndView("index");
//		try {
//			List<String> imageList = image.imageList();
//			 String dishImg = "Default.jpg";
//			for (var img : imageList) {
//				if (img.equalsIgnoreCase(adminUpdate.getDish_Name())) {
//					System.out.println("entered");
//					String dishImage = adminUpdate.getDish_Name() + ".jpg";
//					dishImg = (dishImage);
//					break;
//				}
//			}
//			LocalDate date = LocalDate.now();
//			adminUpdate.setDish_img(dishImg);
//			adminUpdate.setDateOfUpdation(date.toString());
//			System.out.println(adminUpdate);
//			menuRepository.save(adminUpdate);
//			model.addObject(adminUpdate);
//			model.addObject("Items", menuRepository.findAll());
//			model.addObject("path", "../../../Images/");
//		} catch (Exception exception) {
//			System.out.println("Exception caught in postAdminUpdate Method :" + exception);
//		}
//		return model;
//	}
//
//	@RequestMapping(value = "/updatedItemsDetails")
//	public String displayAdminUpdates(ModelMap modelMap) {
//		try {
//			modelMap.put("Items", menuRepository.findAll());
//			modelMap.put("path", "../../../Images/");
//		} catch (Exception exception) {
//			System.out.println("Exception caught in displayAdminUpdates Method :" + exception);
//		}
//		return "index";
//	}
//
//	@RequestMapping("/AdminInterfacePage")
//	public String AdminInterfacePage() {
//		return "AdminInterface";
//	}
//
//	@RequestMapping("/delete/{dishName}")
//	public ModelAndView deleteDish(@PathVariable("dishName") String dishName) {
//		ModelAndView model = new ModelAndView("index");
//		try {
//			adminUpdateService.deletedish(dishName);
//			model.addObject("Items", menuRepository.findAll());
//			model.addObject("path", "../Images/");
//		} catch (Exception exception) {
//			System.out.println("Exception caught in deleteDish Method :" + exception);
//		}
//		return model;
//	}
//
//	@RequestMapping("/edit/{dishName}/{availableQuantity}/{price}/{ingredients}")
//	public ModelAndView editDish(@PathVariable("dishName") String dishName,
//			@PathVariable("availableQuantity") int availableQuantity, @PathVariable("price") float price,
//			@PathVariable("ingredients") String ingredients) {
//		ModelAndView model = new ModelAndView("UpdateAdmin");
//		try {
//			Menu_Table dish = new Menu_Table(dishName, availableQuantity, price, ingredients);
//			adminUpdateService.saveDish(dish);
//			model.addObject("Items", menuRepository.findAll());
//			model.addObject("dishName", dishName);
//			model.addObject("ingredients", ingredients);
//			model.addObject("availableQuantity", availableQuantity);
//			model.addObject("price", price);
//		} catch (Exception exception) {
//			System.out.println("Exception caught in editDish Method :" + exception);
//		}
//		return model;
//	}
//}
package com.food.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.food.model.Image;
import com.food.model.Menu_Table;
import com.food.model.User_Table;
import com.food.repository.MenuRepository;
import com.food.repository.UserTableRepository;
import com.food.services.AdminUpdateService;

@Controller
@RequestMapping("/user")
public class AdminDaoController {
	private static final int ZERO = 0;
	private static final String ADMIN = "admin";
	@Autowired
	AdminUpdateService adminUpdateService;
	@Autowired
	MenuRepository menuTableRepository;
	@Autowired
	UserTableRepository userTableRepository;
	
	Image image = new Image();
	LocalDate date = LocalDate.now();
	@RequestMapping("/updateAdminpage")
	public String updateAdminPage() {
		return "UpdateAdmin";
	}

	@RequestMapping(value = "/UpdateAdmin")
	public ModelAndView postAdminUpdate(Menu_Table dishMenu,@SessionAttribute("user") User_Table user) {
		ModelAndView model = new ModelAndView("index");
		
		try {
			if(userTableRepository.findById(user.getUser_id()).get().getRole().equalsIgnoreCase(ADMIN)) {
			List<String> imageList = image.imageList();
			for (var img : imageList) {
				if ((img.toLowerCase()).equalsIgnoreCase(dishMenu.getDish_Name().toLowerCase())
						||(img.toLowerCase()).contains(dishMenu.getDish_Name().toLowerCase())
						||(dishMenu.getDish_Name().toLowerCase()).contains(img.toLowerCase())) {
					System.out.println("entered");
					String dishImage = img + ".jpg";
					dishMenu.setDish_img(dishImage);
					break;
				} else
					dishMenu.setDish_img("Default.jpg");
			}
			System.out.println(dishMenu);
			adminUpdateService.saveMenuDetails(dishMenu);
			model.addObject(dishMenu);
			model.addObject("path", "../../Images/"); 
			model.addObject("Items", menuTableRepository.findAll());
		
			}  else {
				user.setUser_id(ZERO);
				model = new ModelAndView("login");
				
			}
		} catch (Exception exception) {
			System.out.println("Exception caught in postAdminUpdate Method :" + exception);
		} 
			
		return model;
	}

	@RequestMapping(value = "/updatedItemsDetails")
	public String displayAdminUpdates(ModelMap modelMap,@SessionAttribute("user") User_Table user) {
		String ret ="index";
		try {
			if(userTableRepository.findById(user.getUser_id()).get().getRole().equalsIgnoreCase(ADMIN)) {
			modelMap.put("Items", menuTableRepository.findAll());
			System.out.println(menuTableRepository.findAll());
			modelMap.put("path", "../../Images/");
			}  else {
				user.setUser_id(ZERO);
				ret = "login";
			}
		} catch (Exception exception) {
			System.out.println("Exception caught in displayAdminUpdates Method :" + exception);
		}
		return ret;
	}

	@RequestMapping("/AdminInterfacePage")
	public ModelAndView AdminInterfacePage(@SessionAttribute("user") User_Table user) {
		String ret = "AdminInterface";
		ModelAndView model = new ModelAndView(ret);
		try {
		if(userTableRepository.findById(user.getUser_id()).get().getRole().equalsIgnoreCase(ADMIN)) 
			ret= "AdminInterface";
		else {
			user.setUser_id(ZERO);
			ret = "login";
		}	
		} catch (Exception exception) {
			System.out.println("Exception caught in AdminInterfacePage Method :" + exception);
		}
		model = new ModelAndView(ret);
		return model;
	}

	@RequestMapping("/delete/{dishName}")
	public ModelAndView deleteDish(@PathVariable("dishName") String dishName,@SessionAttribute("user") User_Table user) {
		ModelAndView model = new ModelAndView("index");
		try {
			if(userTableRepository.findById(user.getUser_id()).get().getRole().equalsIgnoreCase(ADMIN)) {
		
			adminUpdateService.deletedish(dishName);
			model.addObject("Items", menuTableRepository.findAll());
			model.addObject("path", "../../../Images/");
			}  else {
				user.setUser_id(ZERO);
				model = new ModelAndView("login");
			}
		} catch (Exception exception) {
			System.out.println("Exception caught in deleteDish Method :" + exception);
		}
		return model;
	}

	@RequestMapping("/edit/{dishName}/{availableQuantity}/{price}/{ingredients}")
	public ModelAndView editDish(@PathVariable("dishName") String dishName,
			@PathVariable("availableQuantity") int availableQuantity, @PathVariable("price") float price,
			@PathVariable("ingredients") String ingredients,@SessionAttribute("user") User_Table user) {
		ModelAndView model = new ModelAndView("UpdateAdmin");
		LocalDate date = LocalDate.now();
		try {
			if(userTableRepository.findById(user.getUser_id()).get().getRole().equalsIgnoreCase(ADMIN)) {
			Menu_Table dish = new Menu_Table();
			dish = menuTableRepository.findById(dishName).get();
			dish.setAvailable_Quantity(availableQuantity);
			dish.setPrice(price);
			dish.setIngredients(ingredients);
			dish.setDate_Of_Updation(date.toString());
			adminUpdateService.saveDish(dish);
			model.addObject("Items", menuTableRepository.findAll());
		
			model.addObject("dishName", dishName);
			model.addObject("ingredients", ingredients);
			model.addObject("availableQuantity", availableQuantity);
			model.addObject("price", price);
			}  else {
				user.setUser_id(ZERO);
				model = new ModelAndView("login");
			}
		} catch (Exception exception) {
			System.out.println("Exception caught in editDish Method :" + exception);
		}
		return model;
	}
}
