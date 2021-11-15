package com.food.repository;
import org.springframework.data.repository.CrudRepository;

import com.food.model.Menu_Table;


public interface AdminUpdateRepo extends CrudRepository<Menu_Table, String> {

}
