package com.masivian.CleanTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.json.*;
import com.masivian.CleanTest.entity.Roulette;
import com.masivian.CleanTest.entity.User;
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
		return new ResponseEntity<>("New Roulette have been created with id: "+ idRoulette, HttpStatus.CREATED);
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
	
	@PostMapping("/betting/{idUser}/{idRoulette}")
	public ResponseEntity<String> betting(@PathVariable int idUser, @PathVariable int idRoulette, @RequestBody Map<String, Object> params){
		User user = userService.findById(idUser);
		Roulette roulette = rouletteService.findById(idRoulette);
		JSONObject parameters = new JSONObject(params);
		if(user != null && roulette != null) {
			return betService.betting(user, roulette, parameters);
		}else {
			return new ResponseEntity<>("Insuficient information - user or roulette not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/closeRoulette/{idRoulette}")
	@ResponseBody
	public ResponseEntity<JSONObject> closeRoulette(@PathVariable int idRoulette) {
		Roulette roulette = rouletteService.findById(idRoulette);
		JSONObject response = new JSONObject();
		if(roulette != null) {
			return rouletteService.closeRoulette(roulette); 
		}else {
			response.append("response", "The roulette with id: "+ idRoulette + " does not exist");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}	
	
	@GetMapping("/listRoulettes")
	public List<Roulette> listRoulettes(){
		return rouletteService.listRoulettes();
	}
}
