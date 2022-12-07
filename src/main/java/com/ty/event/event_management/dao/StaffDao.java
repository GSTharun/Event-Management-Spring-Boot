package com.ty.event.event_management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.event.event_management.dto.Staff;
import com.ty.event.event_management.repository.StaffRepository;

@Repository
public class StaffDao {
	@Autowired
	private StaffRepository staffRepository;

	public Staff saveStaff(Staff staff) {
		return staffRepository.save(staff);
	}

	public Staff updateStaff(Staff staff) {
		return staffRepository.save(staff);
	}

	public Staff getStaffById(int id) {
		Optional<Staff> optional = staffRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public void deleteStaff(Staff staff) {
		staffRepository.delete(staff);

	}
}
