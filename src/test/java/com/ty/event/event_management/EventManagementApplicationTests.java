package com.ty.event.event_management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ty.event.event_management.dto.User;
import com.ty.event.event_management.repository.UserRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EventManagementApplicationTests {

	@Autowired
	UserRepository userRepo;
	
	@Test
	@Order(1)
	public void testUser() {
		User user=new User();
		user.setName("Rakesh");
		user.setGender("male");
		user.setAddress("Bgr");
		user.setDob("12-05-1998");
		user.setEmail("rAkesh@123");
		user.setPassword("123@");
		user.setPhoneno(123456);
		userRepo.save(user);
		assertNotNull(userRepo.findById(4).get());
		
	}
	@Test
	@Order(2)
	public void testSingleUser() {
		User user=userRepo.findById(4).get();
		assertEquals("radhika", user.getName());
		}
	@Test
	@Order(3)
	public void testUpdateUser() {
		User user=userRepo.findById(9).get();
		user.setName("manoj");
		userRepo.save(user);
	}
	@Test
	@Order(4)
	public void testDeleteUser() {
		userRepo.deleteById(7);
	}

}
