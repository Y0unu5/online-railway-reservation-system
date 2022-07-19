package com.cg.orrs.passengerservice.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.orrs.passengerservice.DTO.PassengerDTO;
import com.cg.orrs.passengerservice.entity.Passenger;
import com.cg.orrs.passengerservice.exception.ResourceNotFoundException;
import com.cg.orrs.passengerservice.repository.PassengerRepository;
import com.cg.orrs.passengerservice.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PassengerDTO createPassenger(PassengerDTO passengerDTO) {

		Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
		Passenger passenger2 = passengerRepository.save(passenger);

		return modelMapper.map(passenger2, PassengerDTO.class);
	}

	@Override
	public PassengerDTO updatePassenger(PassengerDTO passengerDTO, Long id) {
		Passenger passenger = this.passengerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Passenger", "Id", id));
		passenger.setFirstName(passengerDTO.getFirstName());
		passenger.setLastName(passengerDTO.getLastName());
		passenger.setEmail(passengerDTO.getEmail());
		passenger.setGender(passengerDTO.getGender());
		passenger.setPhoneNo(passengerDTO.getPhoneNo());

		Passenger updatedPassenger = this.passengerRepository.save(passenger);
		return this.modelMapper.map(updatedPassenger, PassengerDTO.class);
	}

	/**
	 * Listing all passengers from Passenger. streaming through the list of
	 * passenger and it will map the values to PassengerDTO .
	 * 
	 * @Collectors it will collect the data from the list and return a new list.
	 * 
	 */
	@Override
	public List<PassengerDTO> getAllPassengers() {
		List<Passenger> passengers = this.passengerRepository.findAll();
		List<PassengerDTO> passengerDTOs = passengers.stream()
				.map(passenger -> this.modelMapper.map(passenger, PassengerDTO.class)).collect(Collectors.toList());
		return passengerDTOs;
	}

	@Override
	public PassengerDTO getPassengerById(Long id) {
		Passenger passenger = this.passengerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Passenger", "Id", id));

		return this.modelMapper.map(passenger, PassengerDTO.class);
	}

	@Override
	public void deletePassenger(Long id) {

		Passenger passenger = this.passengerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Passenger", "Id", id));
		this.passengerRepository.delete(passenger);
		
	}

}
