package com.team5.Noteapp.Repository;

import org.springframework.data.repository.CrudRepository;

import com.team5.Noteapp.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
