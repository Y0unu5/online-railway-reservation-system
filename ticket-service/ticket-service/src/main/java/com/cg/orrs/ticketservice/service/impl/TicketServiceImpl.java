package com.cg.orrs.ticketservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.orrs.ticketservice.DTO.TicketDTO;
import com.cg.orrs.ticketservice.entity.Ticket;
import com.cg.orrs.ticketservice.exception.ResourceNotFoundException;
import com.cg.orrs.ticketservice.repository.TicketRepository;
import com.cg.orrs.ticketservice.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TicketDTO saveTicket(TicketDTO ticketDTO) {
		Ticket ticket = this.modelMapper.map(ticketDTO, Ticket.class);
		Ticket ticket2 = this.ticketRepository.save(ticket);
		return this.modelMapper.map(ticket2, TicketDTO.class);
	}

	@Override
	public TicketDTO updateTicket(TicketDTO ticketDTO, Long ticketId) {
		Ticket ticket = this.ticketRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket", "Ticket Id", ticketId));
		ticket.setPnrNumber(ticketDTO.getPnrNumber());
		ticket.setQuota(ticketDTO.getQuota());
		ticket.setPassengerMobileNo(ticketDTO.getPassengerMobileNo());
		ticket.setDistance(ticketDTO.getDistance());
		Ticket ticket2 = this.ticketRepository.save(ticket);

		return this.modelMapper.map(ticket2, TicketDTO.class);
	}

	@Override
	public List<TicketDTO> getAllTickets() {
		List<Ticket> tickets = this.ticketRepository.findAll();
		List<TicketDTO> ticketDTOs = tickets.stream().map((ticket) -> this.modelMapper.map(ticket, TicketDTO.class))
				.collect(Collectors.toList());

		return ticketDTOs;
	}

	@Override
	public TicketDTO getTicketById(Long ticketId) {
		Ticket ticket = this.ticketRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket", "Ticket Id", ticketId));

		return this.modelMapper.map(ticket, TicketDTO.class);
	}

	@Override
	public void deleteTicket(Long ticketId) {
		Ticket ticket = this.ticketRepository.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket", "Ticket Id", ticketId));

		this.ticketRepository.delete(ticket);

	}

}
