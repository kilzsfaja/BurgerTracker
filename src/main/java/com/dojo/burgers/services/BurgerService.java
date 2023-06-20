package com.dojo.burgers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.burgers.models.Burger;
import com.dojo.burgers.repositories.BurgerRepository;

@Service
public class BurgerService {
    // adding the Burger repository as a dependency
//	this is the connection to the repository
    private final BurgerRepository burgerRepository;
    
    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }
    // returns all the Burgers (matches name in repository
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }
    // creates a Burger - takes in a Burger Object and saves it to DB
    public Burger createBurger(Burger Burger) {
        return burgerRepository.save(Burger);
    }
    //  ---- FIND ONE ----
    // retrieves a Burger - crud repository uses an Optional object to query database to see if Burger is there, if it is, it returns and Optional object to pull it out.
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
	// ---- EDIT ONE ----
    // update a Burger - if the Burger that you're passing in has a p.key, it finds it and update it, if not it creates a new Burger and assigns a p.key to it.
    public Burger updateBurger(Burger Burger) {
        return burgerRepository.save(Burger);
    }
    
//    ---- DELETE ONE ----
    public String deleteBurger(Long id) {
    	burgerRepository.deleteById(id);
    	return id + " has been deleted.";
    }

}