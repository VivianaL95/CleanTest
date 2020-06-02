package com.masivian.CleanTest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.masivian.CleanTest.entity.Bet;
import com.masivian.CleanTest.entity.Roulette;

@Repository
public class BetDAO implements IBetDAO{

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Bet> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Bet> query = currentSession.createQuery("from bet", Bet.class);
		List<Bet> bets = query.getResultList();
		return bets;
	}

	@Override
	public Bet findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Bet bet = currentSession.get(Bet.class, id);
		return bet;
	}

	@Override
	public void save(Bet bet) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(bet);
	}
}
