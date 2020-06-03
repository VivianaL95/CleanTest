package com.masivian.CleanTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masivian.CleanTest.entity.Bet;
import com.masivian.CleanTest.entity.Roulette;
import com.masivian.CleanTest.entity.User;
import org.json.*;
import com.masivian.CleanTest.dao.BetDAO;

@Service
public class BetService implements IBetService{

	@Autowired
	private BetDAO betDAO;
	
	private RouletteService rouletteService;
	
	@Override
	public List<Bet> findAll() {
		List<Bet> listBets = betDAO.findAll();
		return listBets;
	}

	@Override
	public Bet findById(int id) {
		Bet bet = betDAO.findById(id);
		return bet;
	}

	@Override
	public void save(Bet bet) {
		betDAO.save(bet);
	}

	public ResponseEntity<String> betting(User user, Roulette roulette, JSONObject parameters) {
		try {
			if(roulette.getState()) {
				if(checkBalance(user,parameters)) {
					return createBet(parameters,user,roulette);			
				}else {
					return new ResponseEntity<>("The user does not have enough money for this bet", HttpStatus.BAD_REQUEST);
				}
			}else {
				return new ResponseEntity<>("The roulette can not be used", HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			return new ResponseEntity<>("Betting failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	private ResponseEntity<String> createBet(JSONObject parameters, User user, Roulette roulette) {
		Bet bet = new Bet();	
		ResponseEntity<String> response = validateParameters(parameters);
		if(response == null) {
			bet.setUser(user);
			bet.setRoulette(roulette);
			double value = (double) parameters.get("value");
			bet.setValue(value);
			if(parameters.has("number")) {
				int number = (int) parameters.get("number");
				bet.setNumber(number);
			}if(parameters.has("color")) {
				String color = (String) parameters.get("color");
				bet.setColor(color);
			}
			response = saveBet(bet);	
		}		
		return response;
	}

	private ResponseEntity<String> saveBet(Bet bet) {
		try {
			save(bet);
			return new ResponseEntity<>("Bet created successfully", HttpStatus.OK);
		}catch(Exception e) {
			throw e;
		}
	}

	private ResponseEntity<String> validateParameters(JSONObject parameters) {
		ResponseEntity<String> response = null;
		if(!parameters.has("number") && !parameters.has("color")) {
			response= new ResponseEntity<>("Not enough information - miss number and color", HttpStatus.BAD_REQUEST);
		}if(parameters.has("number")) {
			int number = (int) parameters.get("number");
			if(number<0 || number >36) {
				response= new ResponseEntity<>("Number out of the boundaries", HttpStatus.BAD_REQUEST);
			}
		}if(parameters.has("color")) {
			String color = (String) parameters.get("color");
			if(!color.equals("BLACK") && !color.equals("RED")) {
				response= new ResponseEntity<>("Color not allowed", HttpStatus.BAD_REQUEST);
			}
		}if(parameters.has("value")) {
			double value = (double) parameters.get("value");
			if(value>10000) {
				response= new ResponseEntity<>("Too large value", HttpStatus.BAD_REQUEST);
			}
		}else {
			response= new ResponseEntity<>("Not enough information - miss value", HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}

	private boolean checkBalance(User user, JSONObject parameters) {
		boolean result = false;
		try {
			double value = (double) parameters.get("value");
			if(user.getBalance()>=value) {
				result=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return result;
	}
	
	

	
}
