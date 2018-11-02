package jbr.loginapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.*;

import jbr.loginapp.model.*;
import jbr.loginapp.service.*;



@Controller
public class Login {
	
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("login");
	    mav.addObject("login", new LoginPOJO());
	    //System.out.println(mav);
	    return mav;
	  }
	
	  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("login") LoginPOJO login) {
	    ModelAndView mav = null;
	    
	  try{
		   User user = userService.validateUser(login);
		   boolean ValidUser = userService.isValidUser(user.getUsername());
		          
	    	if (user!= null && login.getUsername()!= null && login.getPassword()!= null && ValidUser == false)  {
	    		mav = new ModelAndView("welcome");
	    		mav.addObject("firstname", user.getFirstname());
	    		mav.addObject("lastname", user.getLastname());
	    		mav.addObject("email", user.getEmail());
	    	} 
	    	else
	    	{
	    		mav = new ModelAndView("login");
	    		mav.addObject("login", login);
	    	    request.setAttribute("message", "Invalid credentials!!");
	  		}
	  } 
	  catch(Exception e)
      {

          e.printStackTrace();

      }
 	
	    return mav;
	   
	  }
	  
	
}
