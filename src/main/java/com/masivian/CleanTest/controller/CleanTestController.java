package com.masivian.CleanTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<String> createRoulette() {
		Roulette roulette = new Roulette();
		int idRoulette = rouletteService.save(roulette);
		return new ResponseEntity<>("New Roulette have been created with id: "+ idRoulette, HttpStatus.OK);
	}
	
	
	@PutMapping("/openRoulette/{idRoulette}")
	public ResponseEntity<String> openRoulette(@PathVariable int idRoulette) {
		Roulette roulette = rouletteService.findById(idRoulette);
		if(roulette != null) {
			return rouletteService.openRoulette(roulette); 
		}else {
			return new ResponseEntity<>("The roulette with id: "+ idRoulette + " does not exist", HttpStatus.NOT_FOUND);
		}
	}
	
	
}
