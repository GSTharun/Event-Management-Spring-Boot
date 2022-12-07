package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.Admin;
import com.ty.event.event_management.repository.AdminRepository;

@Repository
public class AdminDao {
	@Autowired
	AdminRepository adminRepository;

	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin updateAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	public Admin getAdminById(int id) {
		Optional<Admin> optional = adminRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public void deleteAdmin(Admin admin) {
		adminRepository.delete(admin);
	}
}
