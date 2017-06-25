package com.tkd.net.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tkd.net.model.User;
import com.tkd.net.repository.UserRepository;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	private UserRepository userRepository;

	public UserResource() {
		userRepository = new UserRepository();
	}

	@GET
	@Path("/{id}")
	public User getUser(@PathParam("id") Long id) {
		return userRepository.getUser(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public User addUser(User user) {
		return userRepository.addUser(user);
	}
}
