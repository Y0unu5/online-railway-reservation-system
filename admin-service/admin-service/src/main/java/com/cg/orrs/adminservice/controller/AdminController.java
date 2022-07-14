package com.cg.orrs.adminservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@GetMapping("/{id}")
	public String meth() {
		return "Hello World from Admin Service...!";
	}
}
