package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.arguments.UserRequest;
import br.com.aimbra.inspection.arguments.UserResponse;
import br.com.aimbra.inspection.entities.User;

public interface UserService  {
	
	List<UserResponse> findAll();
	UserResponse findById(Long id);
	UserResponse create(UserRequest user);
	UserResponse update(UserRequest user);
	UserResponse delete(UserRequest user);
	
}
