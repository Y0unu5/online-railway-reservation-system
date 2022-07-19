package com.cg.orrs.trainservice.DTO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainDTO {
	private Long trainId;
	private Long trainNo;
	private String trainName;
	private String startPoint;
	private String endPoint;
	private Timestamp arrival;
	private Timestamp departure;
}
