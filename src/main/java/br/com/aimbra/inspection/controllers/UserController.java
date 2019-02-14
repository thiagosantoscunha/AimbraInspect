package br.com.aimbra.inspection.controllers;

import br.com.aimbra.inspection.arguments.UserRequest;
import br.com.aimbra.inspection.arguments.UserResponse;
import br.com.aimbra.inspection.business.UserService;
import br.com.aimbra.inspection.business.UserServiceImpl;

public class UserController {
	
	private UserService userService = new UserServiceImpl();
	
	public UserResponse Create(UserRequest user) {
		return this.userService.create(user);
	}
	
}
