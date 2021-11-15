package com.food.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.model.Order_Table;

public interface OrderTableRepository extends CrudRepository<Order_Table, Integer> {

}
