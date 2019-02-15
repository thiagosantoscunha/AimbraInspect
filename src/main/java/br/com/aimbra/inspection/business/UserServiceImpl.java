package br.com.aimbra.inspection.business;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import br.com.aimbra.inspection.arguments.UserRequest;
import br.com.aimbra.inspection.arguments.UserResponse;
import br.com.aimbra.inspection.entities.User;
import br.com.aimbra.inspection.repositories.UserRepository;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private ModelMapper modelMapper;
	
	public UserServiceImpl() {
		userRepository = new UserRepository();
		modelMapper = new ModelMapper();
	}
	
	@Override
	public List<UserResponse> findAll() {
		try {
			List<User> users = this.userRepository.findAll();
			
			if (users == null) {
				return null;
			}
			
			Type listType = new TypeToken<List<UserResponse>>() {}.getType();
			List<UserResponse> userResponses = this.modelMapper.map(users, listType);
			
			return userResponses;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public UserResponse findById(Long id) {
		try {			
			User user = this.userRepository.findById(id);
			
			if (user == null) {
				return null;
			}
			
			UserResponse userResponse = this.modelMapper.map(user, UserResponse.class);
			return userResponse;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public UserResponse create(UserRequest userRequest) {
		try {
			User user = this.modelMapper.map(userRequest, User.class);
			user = this.userRepository.create(user);
			
			if (user == null) {
				return null;
			}
			
			UserResponse userResponse = this.modelMapper.map(user, UserResponse.class);
			return userResponse;		
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public UserResponse update(UserRequest userRequest) {
		try {
			User user = this.modelMapper.map(userRequest, User.class);
			user = this.userRepository.update(user);
			
			if (user == null) {
				return null;
			}
			
			UserResponse userResponse = this.modelMapper.map(user, UserResponse.class);
			return userResponse;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public UserResponse delete(UserRequest userRequest) {
		try {
			User user = this.modelMapper.map(userRequest, User.class);
			user = this.userRepository.delete(user);
			
			if (user == null) {
				return null;
			}
			
			UserResponse userResponse = this.modelMapper.map(user, UserResponse.class);
			return userResponse;
		} catch (Exception ex) {
			throw ex;
		}
	}

}
