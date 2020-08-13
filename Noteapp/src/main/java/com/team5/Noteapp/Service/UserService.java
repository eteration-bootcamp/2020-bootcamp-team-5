package com.team5.Noteapp.Service;

import com.team5.Noteapp.Entity.HashCode;
import com.team5.Noteapp.Entity.User;
import com.team5.Noteapp.Entity.UserInfo;
import com.team5.Noteapp.Repository.UserInfoRepository;
import com.team5.Noteapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Service
public class UserService {

	@Autowired
	private HashCodeService hashCodeService;

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

	public String login(String username, String pass) throws Exception {
		User user = this.getUserByUserInfo(username, hashCodeService.passwordHash(pass));
		HashCode hashCode;
		if (user != null) {
			hashCode = hashCodeService.createLoginHash(user);
			return hashCode.getCode();
		} else return null;
	}
}
