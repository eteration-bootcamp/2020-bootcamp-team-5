package com.team5.Noteapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.Noteapp.Entity.User;
import com.team5.Noteapp.Repository.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}
}
