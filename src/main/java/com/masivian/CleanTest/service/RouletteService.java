package com.masivian.CleanTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	

}
