package com.team5.Noteapp.Repository;

import java.util.Optional;

import com.team5.Noteapp.Entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.team5.Noteapp.Entity.UserInfo;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
	@Query("SELECT UserInfo FROM UserInfo AS UserInfo WHERE username = ?1")
	Optional<UserInfo> findByUsername(String username);

	@Query("SELECT UserInfo FROM UserInfo AS UserInfo WHERE username = ?1 and password = ?2")
	Optional<UserInfo> findByUsernameAndPassword(String username, String pass);

//    @Query("SELECT UserInfo FROM UserInfo AS UserInfo WHERE mail = ?1")
//    Optional<UserInfo> findByEmail(String email);

	//    @Query("SELECT User FROM UserInfo WHERE user_id = ?1")
//    Optional<User> findByUserId(int userId);
	Optional<UserInfo> findUserInfoByUserId(int userId);

	Optional<UserInfo> findUserInfoByUserMail(String email);

}