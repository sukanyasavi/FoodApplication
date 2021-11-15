package com.food.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order_Table {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false)
	private int order_id;
	private int user_id;
	private String dish_Name;
	private String dish_img;
	private int quantity;
	private float price;
	private String name;
	private String address;
	private long phone_no;
	private String date_of_order;
	private String mode_of_payment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(long l) {
		this.phone_no = l;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getMode_of_payment() {
		return mode_of_payment;
	}

	public void setMode_of_payment(String mode_of_payment) {
		this.mode_of_payment = mode_of_payment;
	}

	public String getDish_img() {
		return dish_img;
	}

	public void setDish_img(String dish_img) {
		this.dish_img = dish_img;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getDish_Name() {
		return dish_Name;
	}

	public void setDish_Name(String dish_Name) {
		this.dish_Name = dish_Name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate_of_order() {
		return date_of_order;
	}

	public void setDate_of_order(String date_of_order) {
		this.date_of_order = date_of_order;
	}

	@Override
	public String toString() {
		return "Order_Table [order_id=" + order_id + ", user_id=" + user_id + ", dish_Name=" + dish_Name + ", dish_img="
				+ dish_img + ", quantity=" + quantity + ", price=" + price + ", name=" + name + ", address=" + address
				+ ", phone_no=" + phone_no + ", date_of_order=" + date_of_order + ", mode_of_payment=" + mode_of_payment
				+ "]";
	}
}
