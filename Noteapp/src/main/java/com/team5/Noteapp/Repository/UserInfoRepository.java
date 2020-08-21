package com.team5.Noteapp.Repository;

import com.team5.Noteapp.Entity.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
	@Query("SELECT UserInfo FROM UserInfo AS UserInfo WHERE username = ?1")
	Optional<UserInfo> findByUsername(String username);

	@Query("SELECT UserInfo FROM UserInfo AS UserInfo WHERE username = ?1 and password = ?2")
	Optional<UserInfo> findByUsernameAndPassword(String username, String pass);

	Optional<UserInfo> findUserInfoByUserId(int userId);
}