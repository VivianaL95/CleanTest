package com.masivian.CleanTest.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masivian.CleanTest.entity.Bet;
import com.masivian.CleanTest.entity.Roulette;
import com.masivian.CleanTest.dao.RouletteDAO;

@Service
public class RouletteService implements IRouletteService{

	@Autowired
	private RouletteDAO rouletteDAO;
	
	private BetService betService;
	
	@Override
	public List<Roulette> findAll() {
		List<Roulette> roulettes = rouletteDAO.findAll();
		return roulettes;
	}

	@Override
	public Roulette findById(int id) {
		Roulette roulette = rouletteDAO.findById(id);
		return roulette;
	}

	@Override
	public int save(Roulette roulette) {
		int id = rouletteDAO.save(roulette);
		return id;
	}

	
	public ResponseEntity<String> openRoulette(Roulette roulette) {
		try {
			if(!roulette.getState()) {
				roulette.setState(true);
				int idRoulette = save(roulette);
				return new ResponseEntity<>("Roulette with id: "+ idRoulette + " is open", HttpStatus.OK);
			}else {
				return new ResponseEntity<>("The roulette is already open", HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			return new ResponseEntity<>("The roulette can not be open - Exception: "+ e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<JSONObject> closeRoulette(Roulette roulette) {
		JSONObject response = new JSONObject();
		try {
			if(roulette.getState()) {
				roulette.setState(false);
				List<Bet> bets = betService.findAll();
				bets = filterByRoulette(bets,roulette.getId());
				save(roulette);
				response.append("bets", bets);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				response.append("response", "The roulette is already closed");
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}			
		}catch(Exception e) {
			response.append("response", "The roulette can not be closed - Exception: "+ e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	private List<Bet> filterByRoulette(List<Bet> bets, int id) {
		List<Bet> betFiltered = new ArrayList<>();
		for(int i = 0;i<bets.size();i++) {
			if(id == bets.get(i).getRoulette().getId()) {
				betFiltered.add(bets.get(i));
			}
		}
		return betFiltered;
	}

	public List<Roulette> listRoulettes() {
		try {
			return rouletteDAO.findAll();		
		}catch(Exception e) {
			throw e;
		}
	}

}
