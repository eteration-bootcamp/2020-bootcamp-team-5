package com.team5.Noteapp.Service;

import com.team5.Noteapp.Entity.UserInfo;
import com.team5.Noteapp.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.Noteapp.Entity.User;
import com.team5.Noteapp.Repository.UserRepository;

import java.util.Optional;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}

	public User getUserByUserInfo(String username, String pass){
		Optional<UserInfo> userInfoOptional = userInfoRepository.findByUsernameAndPassword(username, pass);
		Optional<User> user = null;
		if(userInfoOptional.isPresent()){
			if(userInfoOptional.get().isActive()){
				user = userRepository.findById(userInfoOptional.get().getId());
				if(user.isPresent()){
					return  user.get();
				}
			}
		}
		throw new IllegalArgumentException("Specified user does not exists!");
	}
}
