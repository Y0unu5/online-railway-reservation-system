package com.cg.orrs.trainservice.controller;

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

import com.cg.orrs.trainservice.DTO.TrainDTO;
import com.cg.orrs.trainservice.exception.ApiResponse;
import com.cg.orrs.trainservice.service.TrainService;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

	@Autowired
	private TrainService trainService;

	@GetMapping("/{id}")
	public String meth() {
		return "Hello World from Train Service...!";
	}

	@PostMapping("/")
	public ResponseEntity<TrainDTO> saveTrains(@RequestBody TrainDTO trainDTO) {
		TrainDTO train = this.trainService.saveTrains(trainDTO);

		return new ResponseEntity<TrainDTO>(train, HttpStatus.CREATED);

	}

	@PutMapping("/{trainId}")
	public ResponseEntity<TrainDTO> updateTrain(@RequestBody TrainDTO trainDTO, @PathVariable("trainId") Long id) {
		TrainDTO updateTrains = this.trainService.updateTrain(trainDTO, id);
		return ResponseEntity.ok(updateTrains);
	}

	@GetMapping("/")
	public ResponseEntity<List<TrainDTO>> getAllTrains() {
		return ResponseEntity.ok(this.trainService.getAllTrains());
	}

	@GetMapping("/v2/{trainId}")
	public ResponseEntity<TrainDTO> getTrainById(@PathVariable("trainId") Long id) {
		return ResponseEntity.ok(this.trainService.getTrainById(id));
	}

	@DeleteMapping("/{trainId}")
	public ResponseEntity<ApiResponse> deleteTrain(@PathVariable("trainId") Long id) {
		this.trainService.deleteTrain(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Train Deleted Successfully..", true), HttpStatus.OK);
	}
}
