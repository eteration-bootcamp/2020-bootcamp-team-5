package com.team5.Noteapp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.Noteapp.Entity.UserInfo;
import com.team5.Noteapp.Repository.UserInfoRepository;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public Optional<UserInfo> getByUsername(String username){
		return userInfoRepository.findByUsername(username);
	}
}
