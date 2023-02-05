package com.pariuri.springboot.controller;

import com.pariuri.springboot.model.Bet;
import com.pariuri.springboot.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BetController {

	@Autowired
	private BetService betService;
	
	// display list of bets
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "team1", "asc", model);
	}
	
	@GetMapping("/showNewBetForm")
	public String showNewBetForm(Model model) {
		// create model attribute to bind form data
		Bet bet = new Bet();
		model.addAttribute("bet", bet);
		return "new_bet";
	}
	
	@PostMapping("/saveBet")
	public String saveBet(@ModelAttribute("bet") Bet bet) {
		// save bet to database
		betService.saveBet(bet);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get bet from the service
		Bet bet = betService.getBetById(id);
		
		// set bet as a model attribute to pre-populate the form
		model.addAttribute("bet", bet);
		return "update_bet";
	}
	
	@GetMapping("/deleteBet/{id}")
	public String deleteBet(@PathVariable (value = "id") long id) {
		
		// call delete bet method 
		this.betService.deleteBetById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Bet> page = betService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Bet> listBets = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listBets", listBets);
		return "index";
	}
}
