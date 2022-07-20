package com.cg.orrs.adminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.orrs.adminservice.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}
