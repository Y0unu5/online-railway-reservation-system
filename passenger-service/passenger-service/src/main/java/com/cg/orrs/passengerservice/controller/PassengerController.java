package com.cg.orrs.passengerservice.controller;

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

import com.cg.orrs.passengerservice.DTO.PassengerDTO;
import com.cg.orrs.passengerservice.exception.ApiResponse;
import com.cg.orrs.passengerservice.service.PassengerService;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	@GetMapping("/{id}")
	public String meth() {
		return "Hello World from Passenger Service...!";
	}

	@PostMapping("/")
	public ResponseEntity<PassengerDTO> createPassenger(@RequestBody PassengerDTO passengerDTO) {

		PassengerDTO createPassenger = this.passengerService.createPassenger(passengerDTO);
		return new ResponseEntity<>(createPassenger, HttpStatus.CREATED);
	}

	@PutMapping("/{passengerId}")
	public ResponseEntity<PassengerDTO> updatePassenger(@RequestBody PassengerDTO passengerDTO,
			@PathVariable("passengerId") Long id) {
		PassengerDTO updatePassenger = this.passengerService.updatePassenger(passengerDTO, id);
		return ResponseEntity.ok(updatePassenger);
	}

	@GetMapping("/")
	public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
		return ResponseEntity.ok(this.passengerService.getAllPassengers());
	}

	@GetMapping("/v1/{passengerId}")
	public ResponseEntity<PassengerDTO> getPassengerById(@PathVariable("passengerId") Long id) {
		return ResponseEntity.ok(this.passengerService.getPassengerById(id));
	}

	@DeleteMapping("/{passengerId}")
	public ResponseEntity<ApiResponse> deletePassenger(@PathVariable("passengerId") Long id) {
		this.passengerService.deletePassenger(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Passenger deleted successfully...", true),
				HttpStatus.OK);

	}

}
