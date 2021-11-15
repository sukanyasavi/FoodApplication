package com.food.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.model.Cart_Table;

public interface CartRepository extends CrudRepository<Cart_Table, Integer> {

	

	//Cart getOne(String dish_Name);

	//Cart getOne(int cart_id);

}
