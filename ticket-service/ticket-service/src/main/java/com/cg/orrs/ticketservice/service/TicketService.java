package com.cg.orrs.ticketservice.service;

import java.util.List;

import com.cg.orrs.ticketservice.DTO.TicketDTO;

public interface TicketService {

	TicketDTO saveTicket(TicketDTO ticketDTO);

	TicketDTO updateTicket(TicketDTO ticketDTO, Long ticketId);

	List<TicketDTO> getAllTickets();

	TicketDTO getTicketById(Long ticketId);

	void deleteTicket(Long ticketId);
	
}
