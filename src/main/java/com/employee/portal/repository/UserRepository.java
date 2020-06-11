package com.employee.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.employee.portal.beans.User;

public interface UserRepository extends CrudRepository<User,Integer> {
	
	public User findByemailAddressAndPassword(String email, String password);
	
	public  User  findByEmailAddress(String email);
}
