package jbr.loginapp.controller;

import java.sql.SQLException;



@SuppressWarnings("serial")
public class SpringException extends SQLException{
	
	private String exceptionMsg;
	   
	   public SpringException(String exceptionMsg) {
	      this.exceptionMsg = exceptionMsg;
	   }
	   public String getExceptionMsg(){
	      return this.exceptionMsg;
	   }
	   public void setExceptionMsg(String exceptionMsg) {
	      this.exceptionMsg = exceptionMsg;
	   }

}
