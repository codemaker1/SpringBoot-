package com.employee.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.employee.portal.beans.Ticket;
import com.employee.portal.repository.TicketRepository;
import com.employee.portal.service.TicketService;


@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
    @Cacheable(value="tickets")
	public List<Ticket> findByEmail(String email) {
		 
	return	ticketRepository.findByemailAddress(email);
	
	}
 
	@Override
	@CacheEvict(value="tickets",allEntries = true)
	public void saveTicket(Ticket ticket)
	{
		ticketRepository.save(ticket);
	}

	@Override
	@CacheEvict(value="tickets",allEntries = true)
	public void deleteTicket(Ticket ticket) {
		ticketRepository.delete(ticket);
	}

	@Override
	public Ticket findById(int id) {
		return ticketRepository.findById(id).get();
	}

	@Override
	@CacheEvict(value="tickets",allEntries = true)
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
}
