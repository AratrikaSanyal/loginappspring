package jbr.loginapp.service;

import jbr.loginapp.model.*;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;


import jbr.loginapp.dao.*;
 
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDaoImpl userDao;
	@Override
	public void register(User user)  {
		// TODO Auto-generated method stub
		userDao.register(user);
		
		
	}

	@Override
	public User validateUser(LoginPOJO login) throws SQLException {
		return userDao.validateUser(login);
		
	
		
	}

	@Override
	public boolean isValidUser(String username) throws SQLException  {
		//TODO Auto-generated method stub
		return userDao.isValidUser(username);
	}

}
