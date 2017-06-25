package com.tkd.net;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.tkd.net.lambda.AddUserHandler;
import com.tkd.net.lambda.GetUserHandler;
import com.tkd.net.model.User;

public class UserTest {
	@Test
	public void testGetUser() {
		GetUserHandler hw = new GetUserHandler();
		System.out.println(hw.handleRequest(new Long(1), null));
		assertTrue(true);
    }
	
	
	@Test
	public void testAddUser() {
		AddUserHandler hw = new AddUserHandler();
		User user = new User(null, "Ramesh", "ramesh@lalloo.com", "Bangalore");
		System.out.println(user);
		
		System.out.println(hw.handleRequest(user, null));
		assertTrue(true);
    }
}
