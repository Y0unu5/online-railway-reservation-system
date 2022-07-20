package com.cg.orrs.adminservice.service;

import java.util.List;

import com.cg.orrs.adminservice.DTO.AdminDTO;

public interface AdminService {

	AdminDTO createAdmin(AdminDTO adminDTO);

	AdminDTO updateAdmin(AdminDTO adminDTO, Long adminId);

	List<AdminDTO> getAllAdmins();

	AdminDTO getAdminById(Long adminId);

	void deleteAdmin(Long adminId);

}
