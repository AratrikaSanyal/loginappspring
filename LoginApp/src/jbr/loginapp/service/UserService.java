package jbr.loginapp.service;

import java.sql.SQLException;


import jbr.loginapp.model.LoginPOJO;
import jbr.loginapp.model.User;

public interface UserService {

  void register(User user);
  User validateUser(LoginPOJO login) throws SQLException;
	boolean isValidUser(String username)throws SQLException;


}