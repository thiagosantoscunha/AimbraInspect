package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.arguments.UserRequest;
import br.com.aimbra.inspection.arguments.UserResponse;
import br.com.aimbra.inspection.entities.User;
import br.com.aimbra.inspection.repositories.UserRepository;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository = new UserRepository();
	
	@Override
	public List<UserResponse> findAll() {
		try {
			return this.userRepository.findAll();			
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public UserResponse findById(Long id) {
		try {			
			return this.userRepository.findById(id);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public UserResponse create(UserRequest user) {
		try {
			return this.userRepository.create(user);			
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public UserResponse update(UserRequest user) {
		try {
			return this.userRepository.update(user);			
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public UserResponse delete(UserRequest user) {
		try {
			return this.userRepository.delete(user);			
		} catch (Exception ex) {
			throw ex;
		}
	}

}
