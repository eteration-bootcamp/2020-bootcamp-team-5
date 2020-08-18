package com.team5.Noteapp.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.team5.Noteapp.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    @Query("SELECT User FROM User AS User WHERE mail = ?1")
    Optional<User> findByEmail(String email);


}