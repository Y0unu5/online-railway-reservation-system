package com.cg.orrs.trainservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.orrs.trainservice.DTO.TrainDTO;
import com.cg.orrs.trainservice.entity.Train;
import com.cg.orrs.trainservice.exception.ResourceNotFoundException;
import com.cg.orrs.trainservice.repository.TrainRepository;
import com.cg.orrs.trainservice.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainRepository trainRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public TrainDTO saveTrains(TrainDTO trainDTO) {
		Train train = this.modelMapper.map(trainDTO, Train.class);
		Train train2 = this.trainRepository.save(train);

		return this.modelMapper.map(train2, TrainDTO.class);
	}

	@Override
	public TrainDTO updateTrain(TrainDTO trainDTO, Long id) {
		Train train = this.trainRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Train", "Id", id));

		train.setTrainNo(trainDTO.getTrainNo());
		train.setTrainName(trainDTO.getTrainName());
		train.setStartPoint(trainDTO.getStartPoint());
		train.setEndPoint(trainDTO.getEndPoint());

		Train updateTrain = this.trainRepository.save(train);

		return this.modelMapper.map(updateTrain, TrainDTO.class);
	}

	@Override
	public List<TrainDTO> getAllTrains() {
		List<Train> trains = this.trainRepository.findAll();
		List<TrainDTO> trainDTOs = trains.stream().map(train -> this.modelMapper.map(train, TrainDTO.class))
				.collect(Collectors.toList());
		return trainDTOs;
	}

	@Override
	public TrainDTO getTrainById(Long id) {
		Train train = this.trainRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Train", "Train Id", id));

		return this.modelMapper.map(train, TrainDTO.class);
	}

	@Override
	public void deleteTrain(Long id) {
		Train train = this.trainRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Train", "Train Id", id));
		this.trainRepository.delete(train);

	}

}
