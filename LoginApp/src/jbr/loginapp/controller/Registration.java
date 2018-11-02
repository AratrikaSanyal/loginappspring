package jbr.loginapp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.loginapp.model.User;

import jbr.loginapp.service.UserService;

@Controller
public class Registration {
	@Autowired
	public UserService userservice;

@RequestMapping(value = "/register",method = RequestMethod.GET)
public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    
    mav.addObject("user", new User());
    return mav;
  }
@ExceptionHandler({SpringException.class})
@RequestMapping(value = "/registerProcess",method = RequestMethod.POST)
public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user") User user) throws SpringException {
   
		userservice.register(user);
		return new ModelAndView("welcome", "firstname", user.getFirstname());
    
  }
		 




}
