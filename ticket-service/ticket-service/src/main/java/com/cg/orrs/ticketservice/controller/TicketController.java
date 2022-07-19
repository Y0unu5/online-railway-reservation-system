package com.cg.orrs.ticketservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.orrs.ticketservice.DTO.TicketDTO;
import com.cg.orrs.ticketservice.exception.ApiResponse;
import com.cg.orrs.ticketservice.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@GetMapping("/{id}")
	public String meth() {
		return "Hello World from Ticket Service....!";
	}

	@PostMapping("/")
	public ResponseEntity<TicketDTO> saveTicket(@RequestBody TicketDTO ticketDTO) {
		TicketDTO ticket = this.ticketService.saveTicket(ticketDTO);
		return new ResponseEntity<TicketDTO>(ticket, HttpStatus.CREATED);
	}

	@PutMapping("/{ticketId}")
	public ResponseEntity<TicketDTO> updateTicket(@RequestBody TicketDTO ticketDTO, @PathVariable Long ticketId) {
		TicketDTO ticketDTO2 = this.ticketService.updateTicket(ticketDTO, ticketId);
		return ResponseEntity.ok(ticketDTO2);
	}

	@GetMapping("/")
	public ResponseEntity<List<TicketDTO>> getAllTickets() {
		return ResponseEntity.ok(this.ticketService.getAllTickets());

	}

	@GetMapping("/v1/{ticketId}")
	public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long ticketId) {
		return ResponseEntity.ok(this.ticketService.getTicketById(ticketId));
	}

	@DeleteMapping("/{ticketId}")
	public ResponseEntity<ApiResponse> deleteTicket(@PathVariable Long ticketId) {
		this.ticketService.deleteTicket(ticketId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Ticket successfully deleted..", true), HttpStatus.OK);
	}
}
