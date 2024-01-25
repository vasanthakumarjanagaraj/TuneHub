package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.UserServices;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UsersController {

	@Autowired
	UserServices service;
	
	
	@PostMapping({"/register"})
	public String addUser(@ModelAttribute Users user) {
		
		boolean userStatus=service.emailExist(user.getEmail());
		if(userStatus==false) {
			service.addUser(user);
		return "login";
		}
		else {
			return "accountexist";
		}
		
	}
	
	@PostMapping({"/validate"})
	public String validateUser(@RequestParam("email") String email
			,@RequestParam("password") String password
			, HttpSession session) {
		
		boolean isValid=service.validateUser(email, password);
		if(isValid==true) {
			
			session.setAttribute("email", email);
			
			if(service.findRole(email).equals("Admin")) {
			return"adminlogin";
			}
			else {
				return "userlogin";
			}
		}
		else {
			return "loginproblem";
		}
		
		
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
	
	
}
