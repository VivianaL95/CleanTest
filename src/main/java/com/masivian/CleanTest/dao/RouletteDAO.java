package com.masivian.CleanTest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.masivian.CleanTest.entity.Roulette;

@Repository
public class RouletteDAO implements IRouletteDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Roulette> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Roulette> query = currentSession.createQuery("from roulette", Roulette.class);
		List<Roulette> roulettes = query.getResultList();
		return roulettes;
	}

	@Override
	public Roulette findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Roulette roulette = currentSession.get(Roulette.class, id);
		return roulette;
	}

	@Override
	public int save(Roulette roulette) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(roulette);
		return roulette.getId();
	}

}
