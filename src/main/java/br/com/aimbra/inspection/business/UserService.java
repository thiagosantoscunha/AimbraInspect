package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.arguments.UserRequest;
import br.com.aimbra.inspection.arguments.UserResponse;
import br.com.aimbra.inspection.entities.User;

public interface UserService  {
	
	List<UserResponse> findAll();
	User findById(Long id);
	User create(UserRequest user);
	User update(UserRequest user);
	User delete(UserRequest user);
	
}
