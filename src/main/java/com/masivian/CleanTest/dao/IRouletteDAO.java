package com.masivian.CleanTest.dao;

import java.util.List;
import com.masivian.CleanTest.entity.Roulette;

public interface IRouletteDAO {

	public List<Roulette> findAll();
	
	public Roulette findById(int id);
	
	public int save(Roulette roulette);
	
}
