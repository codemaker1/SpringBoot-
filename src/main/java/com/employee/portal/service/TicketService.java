package com.employee.portal.service;

import java.util.List;

import com.employee.portal.beans.Ticket;

public interface TicketService {
	
	public List<Ticket> findByEmail(String email);
	
	public void saveTicket(Ticket ticket);
	
	public void deleteTicket(Ticket ticket);
	
	public Ticket findById(int id);
	
	public Ticket updateTicket(Ticket ticket);

}
