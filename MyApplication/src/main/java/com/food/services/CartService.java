package com.food.services;

import java.util.List;

import com.food.model.Cart_Table;

public interface CartService {
	public List<Cart_Table> getCartList();

	public void addToCart(Cart_Table cart);

	public Cart_Table getById(int cart_id);

	public void saveOrUpdate(Cart_Table cart);

	public void removefromcart(int cart_id);

	public Cart_Table findById(int cart_id);

	public void deletefromcart(int cart_id);
}
