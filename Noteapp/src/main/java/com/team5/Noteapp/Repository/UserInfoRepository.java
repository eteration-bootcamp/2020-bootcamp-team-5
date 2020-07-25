package com.team5.Noteapp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team5.Noteapp.Entity.UserInfo;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
	@Query("SELECT UserInfo FROM UserInfo AS UserInfo WHERE username = ?1")
	Optional<UserInfo> findByUsername(String username);
}
