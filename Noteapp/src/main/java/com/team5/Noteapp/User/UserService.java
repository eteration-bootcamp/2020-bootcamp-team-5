package com.team5.Noteapp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}
}
