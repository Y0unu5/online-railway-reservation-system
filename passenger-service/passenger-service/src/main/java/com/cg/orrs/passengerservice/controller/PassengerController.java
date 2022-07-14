package com.cg.orrs.passengerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

	@GetMapping("/{id}")
	public String meth() {
		return "Hello World from Passenger Service...!";
	}
}
