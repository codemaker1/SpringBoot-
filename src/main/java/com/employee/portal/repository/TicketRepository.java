package com.employee.portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.employee.portal.beans.Ticket;
import com.employee.portal.beans.User;

public interface TicketRepository extends CrudRepository<Ticket,Integer> {
	
	public List<Ticket> findByemailAddress(String email);
	
}
