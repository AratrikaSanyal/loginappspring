package jbr.loginapp.dao;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import jbr.loginapp.model.LoginPOJO;
import jbr.loginapp.model.User;

import jbr.loginapp.dao.UserMapper;

public class UserDaoImpl implements UserInterface {
	
	@Autowired	
	JdbcTemplate jdbcTemplate;  
	
	@Autowired
	DataSource dataSource ;
	
	@Override
	
	public void register(User user){
		
		// TODO Auto-generated method stub
		   JdbcTemplate query = new JdbcTemplate(dataSource);
		   
		   query.update("insert into users values(?,?,?,?,?)", new Object[] { user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),user.getEmail()
             });
	        
	}
	
		
	
		@Override
         public User validateUser(LoginPOJO login) throws SQLException{
         String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
         + "'";
        
       
         List<User> users = jdbcTemplate.query(sql, new UserMapper());
        
        	if(users.size() > 0 )
        		return users.get(0) ;
         
		return (users.size() > 0 )? users.get(0): null;
		 
         }

		@Override
		public void delete(String username) {
			// TODO Auto-generated method stub
			 
			      String SQL = "delete from users where username = ?";
			      jdbcTemplate.update(SQL, username);
			      System.out.println("Deleted Record with UserName = " + username );
			     
			   }


		public boolean isValidUser(String username) throws SQLException {
			//TODO Auto-generated method stub
			  String SQL = "select * from users where exists( SELECT 1 from users where username=?";
			
			int validity =  jdbcTemplate.update(SQL, username) ;
			 if(validity > 0 )		  
		     return true ;
		      else 
			 return false;
		}


			
		}
       
		
	


