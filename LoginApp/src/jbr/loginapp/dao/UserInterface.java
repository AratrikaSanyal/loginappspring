package jbr.loginapp.dao;

import java.sql.SQLException;


import jbr.loginapp.model.LoginPOJO;
import jbr.loginapp.model.User;

public interface UserInterface {

  void register(User user);
  User validateUser(LoginPOJO login)throws SQLException;
	boolean isValidUser(String username) throws SQLException;
  public void delete (String username);
 
}

