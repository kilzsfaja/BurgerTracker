package com.dojo.burgers.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.burgers.models.Burger;
import com.dojo.burgers.services.BurgerService;



//RestController: responds with raw data (JSON, string literals
//Controller: responds by rendering a JSP page (needs return .jsp)
@RestController
public class BurgersApi {
//	connects to service
 private final BurgerService burgerService;
 public BurgersApi(BurgerService burgerService){
     this.burgerService = burgerService;
 }
// gets all Burgers in DB by using BurgerService called allBurgers() which returns to repository and uses findAll() which gets every Burger in DB
 @RequestMapping("/api/burgers")
 public List<Burger> index() {
     return burgerService.allBurgers();
 }
 
// create a Burger - pass all params in and creates an object in DB
 @PostMapping("/api/burgers")
 public Burger createOne(@RequestParam("burgerName") String burgerName, @RequestParam("restaurantName") String restaurantName, @RequestParam("notes") String notes, @RequestParam("rating") Integer rating) {
     Burger burger = new Burger(burgerName, restaurantName, notes, rating);
     return burgerService.createBurger(burger);
 }
 
// show a Burger - pass in p.key and looks up Burger by p.key
 @GetMapping("/api/burgers/{id}")
 public Burger showOne(@PathVariable("id") Long id) {
     Burger burger = burgerService.findBurger(id);
     return burger;
 }
 
// ---- EDIT ONE ----
 @PutMapping("/api/burgers/{id}")
 public Burger updateOne(
 		@PathVariable("id") Long id, 
 		@RequestParam("burgerName") String burgerName, 
 		@RequestParam("restaurantName") String restaurantName, 
 		@RequestParam("notes") String notes,
 		@RequestParam("rating") Integer rating) {
     Burger burger = new Burger(burgerName, restaurantName, notes, rating);
     burger.setId(id);
     return burgerService.updateBurger(burger);
 }
// ---- DELETE ONE ----
 @DeleteMapping("/api/burgers/{id}")
 public String deleteOne(@PathVariable("id") Long id) {
 	return burgerService.deleteBurger(id);
 }

}