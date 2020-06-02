package com.masivian.CleanTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masivian.CleanTest.dao.UserDAO;
import com.masivian.CleanTest.entity.User;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User findById(int id) {
		User user = userDAO.findById(id);
		return user;
	}

}
