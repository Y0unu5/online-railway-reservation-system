package com.cg.orrs.trainservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trains")
public class TrainController {

	@GetMapping("/{id}")
	public String meth() {
		return "Hello World from Train Service...!";
	}
}
