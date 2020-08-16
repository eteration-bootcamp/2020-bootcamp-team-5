package com.team5.Noteapp.Service;

import com.team5.Noteapp.Dto.UserDto;
import com.team5.Noteapp.Entity.HashCode;
import com.team5.Noteapp.Entity.User;
import com.team5.Noteapp.Entity.UserInfo;
import com.team5.Noteapp.Repository.UserInfoRepository;
import com.team5.Noteapp.Repository.UserRepository;
import com.team5.Noteapp.Validator.EmailValidator;
import com.team5.Noteapp.Validator.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public User getUserByUserInfo(String username, String pass) {
		Optional<UserInfo> userInfoOptional = userInfoRepository.findByUsernameAndPassword(username, pass);
		Optional<User> user = null;
		if (userInfoOptional.isPresent()) {
			if (userInfoOptional.get().isActive()) {
				user = userRepository.findById(userInfoOptional.get().getUser().getId());
				if (user.isPresent()) {
					return user.get();
				}
			}
		}
		throw new IllegalArgumentException("Specified user does not exists!");
	}

	public String login(UserInfo userInfo) throws Exception {
		User user = this.getUserByUserInfo(userInfo.getUsername(), hashCodeService.createPasswordHash(userInfo.getPassword()));
		HashCode hashCode;
		if (user != null) {
			hashCode = hashCodeService.createLoginHash(user);
			return hashCode.getCode();
		} else return null;
	}

	public String signup(UserDto userDto) {
		UserInfo userInfo = new UserInfo();
		User user = new User();
		EmailValidator emailValidator = new EmailValidator();
		PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
		if (userDto != null) {
			user.setName(userDto.getName());
			user.setSurname(userDto.getSurname());
			user.setMail(userDto.getMail());
			user.setPhoneNumber(userDto.getPhoneNumber());
			userInfo.setUsername(userDto.getUsername());
			userInfo.setActive(true);
			userInfo.setPassword(hashCodeService.createPasswordHash(userDto.getPassword()));
			userInfo.setUser(user);
			userInfoRepository.save(userInfo);
			userRepository.save(user);
			System.out.println(userRepository.findById(user.getId()).toString());
			System.out.println(userInfoRepository.findById(userInfo.getId()).toString());
			return "Signup successful!";
		} else throw new IllegalArgumentException("Signup Failed!");
	}

	public void auth(){

	}
}
