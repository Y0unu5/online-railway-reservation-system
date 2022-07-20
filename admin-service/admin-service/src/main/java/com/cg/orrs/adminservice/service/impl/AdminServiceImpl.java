package com.cg.orrs.adminservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.orrs.adminservice.DTO.AdminDTO;
import com.cg.orrs.adminservice.entity.Admin;
import com.cg.orrs.adminservice.exception.ResourceNotFoundException;
import com.cg.orrs.adminservice.repository.AdminRepository;
import com.cg.orrs.adminservice.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AdminDTO createAdmin(AdminDTO adminDTO) {
		Admin admin = this.modelMapper.map(adminDTO, Admin.class);
		Admin admin2 = this.adminRepository.save(admin);

		return this.modelMapper.map(admin2, AdminDTO.class);
	}

	@Override
	public AdminDTO updateAdmin(AdminDTO adminDTO, Long adminId) {
		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "Admin Id", adminId));
		admin.setName(adminDTO.getName());
		admin.setEmail(adminDTO.getEmail());
		admin.setPhoneNo(adminDTO.getPhoneNo());
		admin.setPassword(adminDTO.getPassword());

		Admin admin2 = this.adminRepository.save(admin);

		return this.modelMapper.map(admin2, AdminDTO.class);
	}

	@Override
	public List<AdminDTO> getAllAdmins() {
		List<Admin> admins = this.adminRepository.findAll();
		List<AdminDTO> adminDTOs = admins.stream().map((admin) -> this.modelMapper.map(admin, AdminDTO.class))
				.collect(Collectors.toList());

		return adminDTOs;
	}

	@Override
	public AdminDTO getAdminById(Long adminId) {
		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "Admin Id", adminId));

		return this.modelMapper.map(admin, AdminDTO.class);
	}

	@Override
	public void deleteAdmin(Long adminId) {
		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "Admin Id", adminId));
		this.adminRepository.delete(admin);

	}

}
