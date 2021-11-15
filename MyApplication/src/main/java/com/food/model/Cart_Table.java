package com.food.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart_table")
public class Cart_Table {
	@Id
	private int cart_id;
	private String dish_Name;
	private String dish_img;
	private int user_id;
	private int quantity;
	private float price;
	

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getDish_Name() {
		return dish_Name;
	}

	public void setDish_Name(String dish_Name) {
		this.dish_Name = dish_Name;
	}

	public String getDish_img() {
		return dish_img;
	}

	public void setDish_img(String dish_img) {
		this.dish_img = dish_img;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", dish_Name=" + dish_Name + ", dish_img=" + dish_img + ", user_id="
				+ user_id + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
