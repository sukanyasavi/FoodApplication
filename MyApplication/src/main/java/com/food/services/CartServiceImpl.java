package com.food.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.model.Cart_Table;
import com.food.repository.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	@Autowired
	CartRepository cartRepository;

	@Override
	public void addToCart(Cart_Table cart) {
		try {
			cartRepository.save(cart);

		} catch (Exception exception) {
			System.out.println("Exception caught in addToCart Method :" + exception);
		}
	}

	@Override
	public List<Cart_Table> getCartList() {
		return (List<Cart_Table>) cartRepository.findAll();
	}

	@Override
	public Cart_Table getById(int cart_id) {
		return cartRepository.findById(cart_id).get();
	}

	public void saveOrUpdate(Cart_Table cart) {
		try {
			cartRepository.save(cart);
		} catch (Exception exception) {
			System.out.println("Exception caught in saveOrUpdate Method :" + exception);
		}
	}

	@Override
	public void removefromcart(int cart_id) {
		try {

			cartRepository.deleteById(cart_id);
		} catch (Exception exception) {
			System.out.println("Exception caught in removefromcart Method :" + exception);
		}
	}

	@Override
	public Cart_Table findById(int cart_id) {
		Cart_Table item = cartRepository.findById(cart_id).get();
		return item;
	}

	@Override
	public void deletefromcart(int cart_id) {
		try {
			cartRepository.deleteById(cart_id);
		} catch (Exception exception) {
			System.out.println("Exception caught in deletefromcart Method :" + exception);
		}

	}
}
