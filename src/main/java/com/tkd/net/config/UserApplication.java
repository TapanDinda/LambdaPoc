package com.tkd.net.config;

import com.tkd.net.api.UserResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class UserApplication extends Application<UserConfig> {
	
	public static void main(String[] args) throws Exception {
		if(args.length == 0) args = new String[] {"server"};
		new UserApplication().run(args);
	}

	@Override
	public String getName() {
		return "users";
	}

	@Override
	public void initialize(Bootstrap<UserConfig> bootstrap) {
		// nothing to do yet
	}

	@Override
	public void run(UserConfig configuration, Environment environment) {
		final UserResource resource = new UserResource();
		final UserHealthCheck applHealthCheck = new UserHealthCheck();
		environment.healthChecks().register("users", applHealthCheck);
		//environment.getApplicationContext().setContextPath("/rest");
		environment.jersey().register(resource);
	}
}

