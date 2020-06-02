package com.masivian.CleanTest.service;

import java.util.List;

import com.masivian.CleanTest.entity.Roulette;

public interface IRouletteService {

	public List<Roulette> findAll();
	
	public Roulette findById(int id);
	
	public int save(Roulette roulette);
}
