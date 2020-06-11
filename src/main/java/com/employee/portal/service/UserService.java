package com.employee.portal.service;

import org.springframework.stereotype.Component;

import com.employee.portal.beans.User;


public interface UserService {
	
	public User findByEmailAndPassword(String email, String password);
	
	public User findByEmail(String email);
	
	public User newUser(User user);
	
	

}
