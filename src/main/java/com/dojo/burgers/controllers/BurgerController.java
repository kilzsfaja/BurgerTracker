package com.dojo.burgers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.burgers.models.Burger;
import com.dojo.burgers.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

	@Autowired
	BurgerService burgerService;
	
//	---- SHOW ALL ----
	@GetMapping("/burgers")
	public String allBurgers(Model model) {
		model.addAttribute("allBurgers", burgerService.allBurgers());
		model.addAttribute("burger", new Burger());
		return "index.jsp";
	}
	
//	---- CREATE ONE (form) ----
	@PostMapping("/burgers/create")
//	**** @Valid @ModelAtrributes BindingResults - NEED TO BE STRINGED TOGETHER ****
	public String process(@Valid @ModelAttribute("burger")Burger burger, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()) {
			model.addAttribute("allBurgers", burgerService.allBurgers());
			return "index.jsp";
		} else {
		burgerService.createBurger(burger);
		}
		return "redirect:/burgers";
	}
}
