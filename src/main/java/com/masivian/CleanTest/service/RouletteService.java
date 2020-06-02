package com.masivian.CleanTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.masivian.CleanTest.entity.Roulette;
import com.masivian.CleanTest.dao.RouletteDAO;

@Service
public class RouletteService implements IRouletteService{

	@Autowired
	private RouletteDAO rouletteDAO;
	
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

}
