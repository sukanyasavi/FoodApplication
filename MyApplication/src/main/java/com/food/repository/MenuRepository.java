package com.food.repository;

import org.springframework.data.repository.CrudRepository;
import com.food.model.Menu_Table;

public interface MenuRepository extends CrudRepository<Menu_Table, String> {

	Menu_Table getOne(String dish_Name);

}
