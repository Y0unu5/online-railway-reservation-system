package com.cg.orrs.paymentservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@GetMapping("/{id}")
	public String meth() {
		return "Hello World from Payment Service!";
	}
}
