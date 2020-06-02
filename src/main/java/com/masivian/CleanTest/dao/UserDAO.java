package com.masivian.CleanTest.dao;

import com.masivian.CleanTest.entity.User;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements IUserDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public User findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		User user = currentSession.get(User.class, id);
		return user;
	}

}
