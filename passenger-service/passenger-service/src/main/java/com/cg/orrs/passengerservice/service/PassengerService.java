package com.cg.orrs.passengerservice.service;

import java.util.List;

import com.cg.orrs.passengerservice.DTO.PassengerDTO;

public interface PassengerService {

	PassengerDTO createPassenger(PassengerDTO passengerDTO);

	PassengerDTO updatePassenger(PassengerDTO passengerDTO, Long id);

	List<PassengerDTO> getAllPassengers();

	PassengerDTO getPassengerById(Long id);

	void deletePassenger(Long id);

}
