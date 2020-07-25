package com.team5.Noteapp.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.team5.Noteapp.Entity.HashCode;
import com.team5.Noteapp.Entity.User;
import com.team5.Noteapp.Repository.HashCodeRepository;

@Service
public class HashCodeService {
	
	@Autowired
	private HashCodeRepository hashCodeRepository;
	
	public HashCode createLoginHash(User user) {
		hashCodeRepository.deleteHashCode(user.getId());;
		
		HashCode hashCode = new HashCode();
		long dateMillis = System.currentTimeMillis();
		hashCode.setCode(Hashing.sha256().hashString(dateMillis + user.getMail(), StandardCharsets.UTF_8).toString());
		hashCode.setExDate(new Date(dateMillis + 7200000));
		return hashCodeRepository.save(hashCode);
	}

	public Optional<HashCode> getLoginHash(String code) {
		return hashCodeRepository.findByHashCode(code);
	}
}
