package com.cg.orrs.ticketservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	@GetMapping("/{id}")
	public String meth() {
		return "Hello World from Ticket Service....!";
	}
}
