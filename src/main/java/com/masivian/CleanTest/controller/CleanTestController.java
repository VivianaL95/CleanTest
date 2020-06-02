package com.masivian.CleanTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.CleanTest.entity.Roulette;
import com.masivian.CleanTest.service.BetService;
import com.masivian.CleanTest.service.RouletteService;
import com.masivian.CleanTest.service.UserService;

@RestController
@RequestMapping("/cleantest") 
public class CleanTestController {

	@Autowired
	private BetService betService;
	@Autowired
	private RouletteService rouletteService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/createRoulette")
	public int createRoulette() {
		Roulette roulette = new Roulette();
		return rouletteService.save(roulette);
	}
}
