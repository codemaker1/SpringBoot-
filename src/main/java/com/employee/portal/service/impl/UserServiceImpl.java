package com.employee.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.employee.portal.beans.User;
import com.employee.portal.repository.TicketRepository;
import com.employee.portal.repository.UserRepository;
import com.employee.portal.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Cacheable("user")
	public User findByEmailAndPassword(String email, String password) {
		User result =userRepository.findByemailAddressAndPassword(email,password);
		if(result==null)
		return null;
		return result;
	}

	@Override
	public User newUser(User user) {
		User saveUser = userRepository.save(user);
		return saveUser;
	}

	@Override
	@Cacheable("user")
	public User findByEmail(String email) {
		 User user  = userRepository.findByEmailAddress(email);
		return user;
	}

	
	
}
