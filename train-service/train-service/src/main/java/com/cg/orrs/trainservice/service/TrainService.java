package com.cg.orrs.trainservice.service;

import java.util.List;

import com.cg.orrs.trainservice.DTO.TrainDTO;

public interface TrainService {

	TrainDTO saveTrains(TrainDTO trainDTO);

	TrainDTO updateTrain(TrainDTO trainDTO, Long id);

	List<TrainDTO> getAllTrains();

	TrainDTO getTrainById(Long id);

	void deleteTrain(Long id);

}
