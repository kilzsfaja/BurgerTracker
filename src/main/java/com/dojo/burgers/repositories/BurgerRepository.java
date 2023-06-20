package com.dojo.burgers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.burgers.models.Burger;



@Repository											// model, primary key
public interface BurgerRepository extends CrudRepository<Burger, Long>{
    List<Burger> findAll();

}
