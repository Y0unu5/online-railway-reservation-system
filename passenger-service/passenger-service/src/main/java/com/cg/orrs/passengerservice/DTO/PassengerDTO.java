package com.cg.orrs.passengerservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private Long phoneNo;
	private String address;

}
