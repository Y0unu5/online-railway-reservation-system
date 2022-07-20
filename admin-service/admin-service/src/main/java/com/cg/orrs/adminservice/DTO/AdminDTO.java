package com.cg.orrs.adminservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
	private Long id;
	private String name;
	private String email;
	private Long phoneNo;
	private String password;
}
