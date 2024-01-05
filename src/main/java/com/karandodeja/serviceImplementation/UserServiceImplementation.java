package com.karandodeja.serviceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karandodeja.model.User;
import com.karandodeja.repository.UserRepository;
import com.karandodeja.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserById(Long userId) throws Exception {
		Optional<User> opt = userRepository.findById(userId);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new Exception("User Not Found With" + userId);
	}

}
