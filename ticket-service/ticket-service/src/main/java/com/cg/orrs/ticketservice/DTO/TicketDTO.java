package com.cg.orrs.ticketservice.DTO;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
	private Long ticketId;
	private String pnrNumber;
	private String quota;
	private Timestamp dateOfBooking;
	private Timestamp dateOfJourney;
	private String distance;
	private Long noOfPassengers;
	private Long passengerMobileNo;
}
