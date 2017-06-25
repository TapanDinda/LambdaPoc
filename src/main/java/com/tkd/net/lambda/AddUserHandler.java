package com.tkd.net.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.tkd.net.model.User;
import com.tkd.net.repository.UserRepository;

public class AddUserHandler  implements RequestHandler<User, User> {
	
	private UserRepository userRepository;

	public AddUserHandler() {
		userRepository = new UserRepository();
	}
	
	@Override
	public User handleRequest(User user, Context context) {
        return this.userRepository.addUser(user);
    }
}
