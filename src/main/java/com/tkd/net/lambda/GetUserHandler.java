package com.tkd.net.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.tkd.net.model.User;
import com.tkd.net.repository.UserRepository;

public class GetUserHandler implements RequestHandler<Long, User> {
	
	private UserRepository userRepository;

	public GetUserHandler() {
		userRepository = new UserRepository();
	}
	
	@Override
	public User handleRequest(Long id, Context context) {
        return this.userRepository.getUser(id);
    }
}