package br.com.aimbra.inspection.main;

import br.com.aimbra.inspection.arguments.UserRequest;
import br.com.aimbra.inspection.arguments.UserResponse;
import br.com.aimbra.inspection.controllers.UserController;

public class Main {
	
	public static void main(String[] args) {
		
		UserController userController = new UserController();
		
		UserRequest user = new UserRequest();
		user.setUsername("coddy");
		user.setPassword("123123");
		
		UserResponse userResponse = userController.Create(user);
		
		System.out.println(userResponse);
		
		System.exit(0);
	}

}
