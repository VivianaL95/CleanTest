package com.masivian.CleanTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masivian.CleanTest.entity.Bet;
import com.masivian.CleanTest.dao.BetDAO;

@Service
public class BetService implements IBetService{

	@Autowired
	private BetDAO betDAO;
	
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

}
