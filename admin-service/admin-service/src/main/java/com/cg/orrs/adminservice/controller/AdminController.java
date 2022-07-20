package com.cg.orrs.adminservice.controller;

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

import com.cg.orrs.adminservice.DTO.AdminDTO;
import com.cg.orrs.adminservice.exception.ApiResponse;
import com.cg.orrs.adminservice.service.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/{id}")
	public String meth() {
		return "Hello World from Admin Service...!";
	}

	@PostMapping("/")
	public ResponseEntity<AdminDTO> createAdmin(@RequestBody AdminDTO adminDTO) {

		AdminDTO adminDTO2 = this.adminService.createAdmin(adminDTO);

		return new ResponseEntity<AdminDTO>(adminDTO2, HttpStatus.CREATED);
	}

	@PutMapping("/{adminId}")
	public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO adminDTO, @PathVariable Long adminId) {
		AdminDTO adminDTO2 = this.adminService.updateAdmin(adminDTO, adminId);
		return ResponseEntity.ok(adminDTO2);
	}

	@GetMapping("/")
	public ResponseEntity<List<AdminDTO>> getAllAdmins() {

		return new ResponseEntity<List<AdminDTO>>(this.adminService.getAllAdmins(), HttpStatus.OK);
	}

	@GetMapping("/v1/{adminId}")
	public ResponseEntity<AdminDTO> getAdminById(@PathVariable Long adminId) {
		return new ResponseEntity<AdminDTO>(this.adminService.getAdminById(adminId), HttpStatus.OK);
	}

	@DeleteMapping("/{adminId}")
	public ResponseEntity<ApiResponse> deleteAdmin(@PathVariable Long adminId) {
		this.adminService.deleteAdmin(adminId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Admin successfully deleted..", true), HttpStatus.OK);
	}
}
