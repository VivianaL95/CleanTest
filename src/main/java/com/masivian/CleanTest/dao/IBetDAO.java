package com.masivian.CleanTest.dao;

import java.util.List;
import com.masivian.CleanTest.entity.Bet;

public interface IBetDAO {
	
	public List<Bet> findAll();
	
	public Bet findById(int id);
	
	public void save(Bet bet);
}
