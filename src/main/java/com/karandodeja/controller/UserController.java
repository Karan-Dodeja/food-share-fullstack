package com.karandodeja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karandodeja.model.User;
import com.karandodeja.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/users")
	public User createUser(@RequestBody User user) throws Exception {
		User isExits = userRepository.findByEmail(user.getEmail());
		if (isExits != null) {
			throw new Exception("User Not Found." + user.getEmail());
		}
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@DeleteMapping("/users/{userId}")
	public String createUser(@PathVariable("id") Long userId) throws Exception {
		userRepository.deleteById(userId);
		return "User deleted Successfully.";
	}

	@GetMapping("/users")
	public List<User> getUser() throws Exception {
		List<User> findUser = userRepository.findAll();
		return findUser;
	}

}
