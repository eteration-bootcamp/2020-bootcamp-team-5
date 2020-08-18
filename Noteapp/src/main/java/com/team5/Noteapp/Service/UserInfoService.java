package com.team5.Noteapp.Service;

import com.team5.Noteapp.Entity.UserInfo;
import com.team5.Noteapp.Repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private HashCodeService hashCodeService;

	public Optional<UserInfo> getByUsername(String username){
		return userInfoRepository.findByUsername(username);
	}

	public void resetPassword(int userId, String newPassword){
		Optional<UserInfo> userInfoOptional = userInfoRepository.findUserInfoByUserId(userId);
		if (userInfoOptional.isPresent()){
			userInfoOptional.get().setPassword(hashCodeService.createPasswordHash(newPassword));
			userInfoRepository.save(userInfoOptional.get());
			System.out.println(userInfoOptional.get().toString());
		}else throw new IllegalArgumentException("Password could not be updated");
	}

	public void activateAccount(int userId){
		Optional<UserInfo> userInfoOptional = userInfoRepository.findUserInfoByUserId(userId);
		if (userInfoOptional.isPresent()){
			userInfoOptional.get().setActive(true);
			userInfoRepository.save(userInfoOptional.get());
			System.out.println(userInfoOptional.get().toString());
		}else throw new IllegalArgumentException("Failed to activate account");
	}
}