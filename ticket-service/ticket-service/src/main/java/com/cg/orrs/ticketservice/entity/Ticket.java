package com.cg.orrs.ticketservice.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	private String pnrNumber;
	private String quota;
	private Timestamp dateOfBooking;
	private Timestamp dateOfJourney;
	private String distance;
	private Long noOfPassengers;
	private Long passengerMobileNo;

}
