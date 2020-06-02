package com.masivian.CleanTest.service;

import java.util.List;

import com.masivian.CleanTest.entity.Bet;

public interface IBetService {

	public List<Bet> findAll();
	
	public Bet findById(int id);
	
	public void save(Bet bet);
}
